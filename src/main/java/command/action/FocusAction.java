package command.action;

import command.ParamNode;
import constants.Constants;
import data.TaskList;
import jobs.Deadline;
import jobs.Event;
import jobs.Task;
import jobs.ToDo;
import messages.MessageOptions;

import java.util.ArrayList;

public class FocusAction extends Action{
    private String typeTask;

    @Override
    public String act(TaskList tasks) {
        tasks.indices = new ArrayList<>();
        if (typeTask == null || typeTask.length() == 0) {
            StringBuilder builder = new StringBuilder(Constants.NO_KEYWORD);
            for (Task task : tasks.tasks) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                tasks.indices.add(tasks.indexOf(task));
            }
            if (builder.toString().equals(Constants.NO_KEYWORD)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                tasks.indexOption = MessageOptions.INDEXED_NUM;
            }
            return builder.toString();
        } else if(typeTask.equals(Constants.DEADLINE)){
            ArrayList<Task> filtered = new ArrayList<>(tasks.tasks);
            filtered.removeIf(t-> !(t instanceof Deadline));
            StringBuilder builder = new StringBuilder();
            for (Task task : filtered) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                tasks.indices.add(tasks.indexOf(task));
            }
            if (builder.toString().equals(Constants.ZERO_LENGTH_STRING)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                tasks.indexOption = MessageOptions.INDEXED_NUM;
            }
            String result = super.act(tasks);
            return result.replace(Constants.TEXT_PLACEHOLDER, builder.toString());
        } else if(typeTask.equals(Constants.TODO)){
            ArrayList<Task> filtered = new ArrayList<>(tasks.tasks);
            filtered.removeIf(t-> !(t instanceof ToDo));
            StringBuilder builder = new StringBuilder();
            for (Task task : filtered) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                tasks.indices.add(tasks.indexOf(task));
            }
            if (builder.toString().equals(Constants.ZERO_LENGTH_STRING)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                tasks.indexOption = MessageOptions.INDEXED_NUM;
            }
            String result = super.act(tasks);
            return result.replace(Constants.TEXT_PLACEHOLDER, builder.toString());
        } else if(typeTask.equals(Constants.EVENT)){
            ArrayList<Task> filtered = new ArrayList<>(tasks.tasks);
            filtered.removeIf(t-> !(t instanceof Event));
            StringBuilder builder = new StringBuilder();
            for (Task task : filtered) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                tasks.indices.add(tasks.indexOf(task));
            }
            if (builder.toString().equals(Constants.ZERO_LENGTH_STRING)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                tasks.indexOption = MessageOptions.INDEXED_NUM;
            }
            String result = super.act(tasks);
            return result.replace(Constants.TEXT_PLACEHOLDER, builder.toString());
        } else{
            StringBuilder builder = new StringBuilder(Constants.NO_KEYWORD);
            for (Task task : tasks.tasks) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                tasks.indices.add(tasks.indexOf(task));
            }
            if (builder.toString().equals(Constants.NO_KEYWORD)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                tasks.indexOption = MessageOptions.INDEXED_NUM;
            }
            return builder.toString();
        }
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        if (args.thisData == null) {
            typeTask = null;
        } else {
            typeTask = args.thisData.toFlatString();
        }
    }
}

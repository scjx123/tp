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

/**
 * The type Focus action.
 */
public class FocusAction extends Action {
    private String typeTask;
    public static String taskFlag = Constants.ALL;

    public String getTaskFlag() {
        return taskFlag;
    }

    public void setTaskFlag(String taskFlag) {
        this.taskFlag = taskFlag;
    }

    @Override
    public String act(TaskList tasks) {
        tasks.indices = new ArrayList<>();
        if (typeTask == null || typeTask.length() == 0) {
            StringBuilder builder = new StringBuilder(Constants.NO_TASK_TYPE);
            for (Task task : tasks.tasks) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                tasks.indices.add(tasks.indexOf(task));
            }
            if (builder.toString().equals(Constants.NO_TASK_TYPE)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                tasks.indexOption = MessageOptions.INDEXED_NUM;
            }
            return builder.toString();
        } else if (typeTask.toLowerCase().equals(Constants.DEADLINE)) {
            StringBuilder builder = new StringBuilder();
            builder.append(Constants.CONTEXT_MSG);
            builder.append(Constants.DEADLINE);
            setTaskFlag(Constants.DEADLINE);
            return builder.toString();
        } else if (typeTask.toLowerCase().equals(Constants.TODO)) {
            setTaskFlag(Constants.TODO);
            StringBuilder builder = new StringBuilder();
            builder.append(Constants.CONTEXT_MSG);
            builder.append(Constants.TODO);
            return builder.toString();

        } else if (typeTask.toLowerCase().equals(Constants.EVENT)) {
            setTaskFlag(Constants.EVENT);
            StringBuilder builder = new StringBuilder();
            builder.append(Constants.CONTEXT_MSG);
            builder.append(Constants.EVENT);
            return builder.toString();
        } else if (typeTask.toLowerCase().equals(Constants.ALL)) {
            setTaskFlag(Constants.ALL);
            StringBuilder builder = new StringBuilder();
            builder.append(Constants.CONTEXT_MSG);
            builder.append(Constants.ALL);
            return builder.toString();
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(Constants.INVALID);
            builder.append(Constants.FOCUS_HELP);
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

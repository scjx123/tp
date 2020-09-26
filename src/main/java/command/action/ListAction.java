package command.action;

import constants.Constants;
import data.TaskList;
import jobs.Task;
import messages.MessageOptions;

public class ListAction extends Action {

    @Override
    public String act(TaskList tasks) {
        StringBuilder builder = new StringBuilder();
        tasks.indexOption = MessageOptions.INDEXED_NUM;
        for (Task task: tasks.tasks) {
            builder.append(task.toString()).append(Constants.WIN_NEWLINE);
        }
        return builder.toString();
    }
}

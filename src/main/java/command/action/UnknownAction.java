package command.action;

import constants.Constants;
import data.TaskList;

public class UnknownAction extends Action {

    @Override
    public String act(TaskList tasks) {
        return Constants.messageMap.getOrDefault(Constants.UNKNOWN, Constants.INVALID);
    }

}

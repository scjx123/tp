package command.action;

import constants.Constants;
import data.TaskList;

/**
 * The type Plain action.
 */
public class PlainAction extends Action {

    /**
     * Instantiates a new Plain action.
     */
    public PlainAction() {
        super();
    }

    @Override
    public String act(TaskList tasks) {
        return Constants.WELCOME;
    }

}

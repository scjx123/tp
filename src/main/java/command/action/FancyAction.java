package command.action;

import constants.Constants;
import data.TaskList;

/**
 * The type Fancy action.
 */
public class FancyAction extends Action {

    /**
     * Instantiates a new Fancy action.
     */
    public FancyAction() {
        super();
    }

    @Override
    public String act(TaskList tasks) {
        return Constants.WELCOME;
    }

}

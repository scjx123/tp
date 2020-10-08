package command.action;

import constants.Constants;
import data.Data;

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
    public String act(Data data) throws Exception {
        return Constants.WELCOME;
    }

}

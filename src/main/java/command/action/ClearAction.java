package command.action;

import data.Data;

/**
 * The type Clear action.
 */
public class ClearAction extends Action {

    @Override
    public String act(Data data) {
        data.getTarget().clear();
        return super.act(data);
    }

}

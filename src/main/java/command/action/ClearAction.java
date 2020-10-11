package command.action;

import data.Data;

/**
 * The type Clear action.
 */
public class ClearAction extends Action {

    @Override
    public String act(Data data) throws Exception {
        data.getTarget().clear();
        return super.act(data);
    }

}

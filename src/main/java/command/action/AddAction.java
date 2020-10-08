package command.action;

import command.ParamNode;
import data.Data;

/**
 * The type Add action (on progress).
 */
public class AddAction extends Action {

    private ParamNode args;

    @Override
    public String act(Data data) throws Exception {
        // do stuff
        return "";
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        this.args = args;
    }
}

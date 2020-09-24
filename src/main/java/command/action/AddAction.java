package command.action;

import command.ParamNode;
import data.Data;

public class AddAction implements Action {

    private ParamNode args;

    @Override
    public boolean act(Data tasks) {
        // do stuff
        return true;
    }

    @Override
    public void prepare(ParamNode args) {
        this.args = args;
    }
}

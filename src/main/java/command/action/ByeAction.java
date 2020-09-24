package command.action;

import command.ParamNode;
import data.Data;

public class ByeAction implements Action {

    @Override
    public boolean act(Data tasks) {
        return false;
    }

    @Override
    public void prepare(ParamNode args) {

    }
}

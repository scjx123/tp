package command.action;

import command.ParamNode;
import data.Data;

public class AddAction implements Action {

    private ParamNode args;

    @Override
    public void act(Data tasks) {

    }

    @Override
    public void prepare(ParamNode args) {
        this.args = args;
    }
}

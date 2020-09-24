package command.action;

import command.ParamNode;
import data.Data;

public class ListAction implements Action {

    private ParamNode args;

    @Override
    public void act(Data tasks) {
        tasks.updateListUI(null);
    }

    @Override
    public void prepare(ParamNode args) {
        this.args = args;
    }
}

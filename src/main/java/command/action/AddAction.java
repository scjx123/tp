package command.action;

import command.ParamNode;
import data.TaskList;

public class AddAction extends Action {

    private ParamNode args;

    @Override
    public String act(TaskList tasks) {
        // do stuff
        return "";
    }

    @Override
    public void prepare(ParamNode args) {
        this.args = args;
    }
}

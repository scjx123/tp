package command.action;

import command.ParamNode;
import data.TaskList;

/**
 * The type Add action.
 */
public class AddAction extends Action {

    private ParamNode args;

    @Override
    public String act(TaskList tasks) {
        // do stuff
        return "";
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        this.args = args;
    }
}

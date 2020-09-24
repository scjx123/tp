package command.action;

import command.ParamNode;
import constants.Constants;
import constants.HelpText;
import data.Data;

public class HelpAction implements Action {

    private ParamNode args;

    @Override
    public boolean act(Data tasks) {
        tasks.updateSelUI(Constants.helpMap.getOrDefault(args.name, HelpText.LIST).toString()); //later change to help
        return true;
    }

    @Override
    public void prepare(ParamNode args) {
        this.args = args;
    }
}

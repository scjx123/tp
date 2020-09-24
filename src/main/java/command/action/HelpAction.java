package command.action;

import command.ParamNode;
import constants.Constants;
import constants.HelpText;
import data.Data;

public class HelpAction implements Action {

    private ParamNode args;

    @Override
    public void act(Data tasks) {
        tasks.updateSelUI(Constants.helpMap.getOrDefault(args.name, HelpText.LIST).toString()); //later change to help
    }

    @Override
    public void prepare(ParamNode args) {
        this.args = args;
    }
}

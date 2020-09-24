package command;

import command.action.HelpAction;
import constants.Constants;
import constants.HelpText;
import command.action.Action;
import data.Data;

public class Command implements Help{

    public ParamNode args;
    public String name;
    private HelpText helpText;
    public Action action;

    public Command(ParamNode args) {
        this.args = args;
        name = args.name;
        helpText = Constants.helpMap.getOrDefault(name, HelpText.LIST); // later change to help.
        initiateAction();
    }

    private void initiateAction() {
        action = Constants.actionMap.getOrDefault(name, new HelpAction());
    }

    public void act(Data tasks) {
        action.prepare(args);
        action.act(tasks);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return helpText.description;
    }

    @Override
    public String[] getSyntax() {
        return helpText.syntax;
    }

    @Override
    public String[] getUsages() {
        return helpText.usages;
    }

    @Override
    public String getHelp() {
        return helpText.toString();
    }

    @Override
    public String toString() {
        return args.toString();
    }

}

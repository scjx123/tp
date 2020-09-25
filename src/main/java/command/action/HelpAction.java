package command.action;

import constants.HelpText;
import command.ParamNode;
import constants.Constants;
import data.TaskList;

public class HelpAction extends Action {

    boolean isDetailed = false;
    HelpText helpText = null;

    @Override
    public String act(TaskList tasks) {
        if (isDetailed && helpText != null) {
            return helpText.toString();
        } else {
            StringBuilder builder = new StringBuilder();
            for (HelpText help: HelpText.values()) {
                builder.append("Command: ").append(help.name).append(Constants.SPACE).append(Constants.SPACE).append(
                        "Description: ").append(help.description).append(Constants.WIN_NEWLINE);
            }
            builder.append(Constants.HELP_PROMPT);
            return builder.toString();
        }
    }

    @Override
    public void prepare(ParamNode args) {
        super.prepare(args);
        if (flattenedArgs.length > 0) {
            String target = flattenedArgs[0].name;
            if (target != null) {
                isDetailed = true;
                helpText = Constants.helpMap.get(target);
            }
        }
    }
}

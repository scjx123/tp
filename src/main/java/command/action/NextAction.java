package command.action;

import command.ParamNode;
import constants.Constants;
import data.TaskList;

/**
 * The type Next action.
 */
public class NextAction extends Action {

    private String arg = "a";

    @Override
    public String act(TaskList tasks) {
        String result = PrevAction.getTargetString(Constants.optionalParamMap.get(args.name), arg);
        result = result + "1";
        return super.act(tasks).replace(Constants.TEXT_PLACEHOLDER, result);
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        int len = flattenedArgs.length;
        if (len > 0) {
            arg = flattenedArgs[0].name.toLowerCase().trim();
        }
    }

}

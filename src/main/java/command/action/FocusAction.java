package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;

/**
 * The type Focus action.
 */
public class FocusAction extends Action {
    private String typeTask;

    @Override
    public String act(Data data) {
        data.setFlag(typeTask);
        String output = super.act(data);
        return output.replace(Constants.TEXT_PLACEHOLDER, typeTask);
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        if (args.thisData == null) {
            typeTask = Constants.TASK;
        } else {
            typeTask = args.thisData.name;
            String[] options = Constants.optionalParamMap.get(args.name);
            int count = 0;
            for (String opt : options) {
                if (opt.equals(typeTask)) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == options.length) {
                throw new Exception();
            }
        }
    }
}

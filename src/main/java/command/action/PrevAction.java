package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;

/**
 * The type Prev action.
 */
public class PrevAction extends Action {

    private String arg = "a";

    @Override
    public String act(Data data) {
        String result = getTargetString(Constants.optionalParamMap.get(args.name), arg);
        result = result + "-1";
        return super.act(data).replace(Constants.TEXT_PLACEHOLDER, result);
    }

    /**
     * Gets target string.
     *
     * @param params the params
     * @param arg    the arg
     * @return the target string
     */
    static String getTargetString(String[] params, String arg) {
        String result = "";
        String i = params[0];
        String s = params[1];
        String a = params[2];
        if (arg.equals(i)) {
            result = Constants.BMP_LIST_SWITCH;
        } else if (arg.equals(s)) {
            result = Constants.BMP_SEL_SWITCH;
        } else if (arg.equals(a)) {
            result = Constants.BMP_LIST_SWITCH + Constants.BMP_SEL_SWITCH;
        }
        return result;
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

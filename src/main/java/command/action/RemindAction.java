package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;

/**
 * The type Remind action.
 */
public class RemindAction extends Action{

    private String remindAt;

    public RemindAction() {
        super();
    }

    @Override
    public String act(Data data) throws Exception {
        return super.act(data).replace(Constants.TEXT_PLACEHOLDER, getSchedule());
    }

    public String getSchedule() {
        return remindAt;
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        remindAt = args.thisData.toFlatString();
    }
}

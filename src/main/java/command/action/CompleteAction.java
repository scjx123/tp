//@@author TomLBZ

package command.action;

import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;

public class CompleteAction extends TakeAction {

    @Override
    public String act(Data data) throws Exception {
        return super.act(data).replace("taken or untaken", "completed")
                .replace(Constants.MODIFY_FAILED, Constants.NOT_COMPLETABLE);
    }

    @Override
    protected boolean modifyObject(Item item) {
        assert item instanceof SingleModule;
        return ((SingleModule) item).complete();
    }
}

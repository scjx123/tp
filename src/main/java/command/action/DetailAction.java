package command.action;

import data.Item;

public class DetailAction extends TakeAction {

    @Override
    protected void modifyObject(Item item) {
        // do nothing
    }

    @Override
    protected String getObjectInfo(Item item) {
        return item.getDetails();
    }

}

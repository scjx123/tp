package command.action;

import data.Item;
import data.SingleModule;

public class UntakeAction extends TakeAction {
    @Override
    protected void modifyObject(Item item) {
        ((SingleModule)item).isTaken = false;
        ((SingleModule)item).grade = null;
    }
}

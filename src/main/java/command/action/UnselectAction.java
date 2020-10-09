package command.action;

import data.Item;

public class UnselectAction extends SelectAction{
    @Override
    protected void modifyObject(Item item) {
        item.isSelected = false;
    }
}

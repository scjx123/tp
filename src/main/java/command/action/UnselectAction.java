//@@author TomLBZ
package command.action;

import data.Item;

public class UnselectAction extends SelectAction {
    @Override
    protected boolean modifyObject(Item item) {
        item.isSelected = false;
        return true;
    }
}

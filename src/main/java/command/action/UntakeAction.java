//@@author TomLBZ

package command.action;

import data.Item;
import data.SingleModule;

/**
 * The type Untake action.
 */
public class UntakeAction extends TakeAction {
    @Override
    protected boolean modifyObject(Item item) {
        if (((SingleModule)item).isCompleted) {
            return false;
        }
        ((SingleModule)item).isTaken = false;
        ((SingleModule)item).grade = null;
        return true;
    }
}

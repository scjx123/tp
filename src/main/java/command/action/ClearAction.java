//@@author TomLBZ

package command.action;

import data.Data;
import data.Item;

import java.util.ArrayList;

/**
 * The type Clear action.
 */
public class ClearAction extends Action {

    @Override
    public String act(Data data) throws Exception {
        ArrayList<Item> items = new ArrayList<>(data.getTarget());
        items.forEach(data::removeItem);
        return super.act(data);
    }

}

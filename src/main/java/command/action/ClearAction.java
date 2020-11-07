//@@author TomLBZ

package command.action;

import constants.Constants;
import data.Data;
import data.Item;

import java.util.ArrayList;

/**
 * The type Clear action.
 */
public class ClearAction extends Action {

    @Override
    public String act(Data data) throws Exception {
        if (flattenedArgs != null && flattenedArgs.length > 0) {
            if (flattenedArgs[0].name.toLowerCase().equals("fancy")) {
                return "I have cleared the text region for the fancy UI." + Constants.WIN_NEWLINE;
            }
        }
        ArrayList<Item> items = new ArrayList<>(data.getTarget());
        items.forEach(data::removeItem);
        return super.act(data);
    }

}

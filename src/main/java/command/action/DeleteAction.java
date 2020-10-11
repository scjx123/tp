package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;

/**
 * The type Delete action.
 */
public class DeleteAction extends Action {

    private int index;

    @Override
    public String act(Data data) throws Exception {
        if (index < 0 || index >= data.target.size()) {
            return Constants.INDEX_OUT;
        }
        Item item = data.get(index);
        String result = super.act(data);
        data.removeItem(index);
        return replaceStrings(result, item.toString(), data.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        index = getIndex(args.thisData.name);
    }
}

//@@author TomLBZ

package command.action;

import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import exceptions.ItemNotSpecifiedException;

/**
 * The type Select action.
 */
public class SelectAction extends TakeAction {

    @Override
    public String act(Data data) throws Exception {
        data.refreshTarget();
        StringBuilder builder = new StringBuilder();
        if (codes != null && codes.size() > 0) {
            data.mods.stream().filter(x -> codes.contains(((SingleModule) x).moduleCode)).forEach(m -> {
                modifyObject(m);
                builder.append("Item: ").append(getObjectInfo(m)).append(Constants.WIN_NEWLINE);
            });
        }
        if (!indices.isEmpty()) {
            for (int i : indices) {
                if (i < 0 || i > data.target.size() - 1) {
                    throw new IndexOutOfBoundsException();
                }
                modifyObject(data.target.get(i));
                builder.append("Item ").append(i + 1).append(": ")
                        .append(getObjectInfo(data.get(i))).append(Constants.WIN_NEWLINE);
            }
        }
        String result = superAct(data);
        String execution = builder.toString();
        if (execution.equals(Constants.ZERO_LENGTH_STRING)) {
            execution = execution.concat(Constants.NOT_FOUND);
        }
        return result.replace(Constants.TEXT_PLACEHOLDER, execution);
    }

    @Override
    protected boolean modifyObject(Item item) {
        item.isSelected = true;
        return true;
    }

    @Override
    protected void safetyCheck() throws Exception {
        throw new ItemNotSpecifiedException();
    }

    @Override
    protected String superAct(Data data) throws Exception {
        return super.superAct(data);
    }
}

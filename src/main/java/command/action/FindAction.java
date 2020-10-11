package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import messages.MessageOptions;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The type Find action.
 */
public class FindAction extends Action {

    private String keyword;

    @Override
    public String act(Data data) throws Exception {
        if (keyword == null || keyword.length() == 0) {
            StringBuilder builder = new StringBuilder(Constants.NO_KEYWORD);
            data.refreshTarget();
            for (Item item : data.target) {
                builder.append(item.toString()).append(Constants.WIN_NEWLINE);
            }
            if (builder.toString().equals(Constants.NO_KEYWORD)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                data.indexOption = MessageOptions.INDEXED_NUM;
            }
            return builder.toString();
        } else {
            String result = super.act(data);
            if (data.target == null) {
                return result.replace(Constants.TEXT_PLACEHOLDER, Constants.NOT_FOUND);
            }
            data.target = data.target.stream().filter(
                x -> x.toString().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
            StringBuilder builder = new StringBuilder();
            for (Item item : data.target) {
                builder.append(item.toString()).append(Constants.WIN_NEWLINE);
            }
            if (builder.toString().equals(Constants.ZERO_LENGTH_STRING)) {
                builder.append(Constants.NOT_FOUND);
            } else {
                data.indexOption = MessageOptions.INDEXED_NUM;
            }
            return result.replace(Constants.TEXT_PLACEHOLDER, builder.toString());
        }
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        if (args.thisData == null) {
            keyword = null;
        } else {
            keyword = args.thisData.toFlatString();
        }
    }
}

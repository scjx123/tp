package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import exceptions.CommandException;
import exceptions.ItemNotSpecifiedException;

import java.util.ArrayList;

public class SelectAction extends Action {
    private ArrayList<Integer> indices;
    private ArrayList<String> codes;

    @Override
    public String act(Data data) throws Exception {
        data.refreshTarget();
        StringBuilder builder = new StringBuilder();
        if (codes != null && codes.size() > 0) {
            data.mods.stream().filter(x -> codes.contains(((SingleModule)x).moduleCode)).forEach(m -> {
                m.isSelected = true;
                builder.append("Item: ").append(m.getName()).append(Constants.WIN_NEWLINE);
            });
        }
        if (!indices.isEmpty()) {
            for (int i : indices) {
                if (i < 0 || i > data.target.size() - 1) {
                    throw new IndexOutOfBoundsException();
                }
                data.target.get(i).isSelected = true;
                builder.append("Item ").append(i + 1).append(": ").
                        append(data.get(i).getName()).append(Constants.WIN_NEWLINE);
            }
        }
        String result = super.act(data);
        String execution = builder.toString();
        if (execution.equals(Constants.ZERO_LENGTH_STRING)) {
            execution = execution.concat(Constants.NOT_FOUND);
        }
        return result.replace(Constants.TEXT_PLACEHOLDER, execution);
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        indices = new ArrayList<>();
        codes = new ArrayList<>();
        if (args.thisData == null) {
            throw new ItemNotSpecifiedException();
        }
        String[] elements = args.thisData.toFlatString().split(Constants.SPACE);
        for (String string : elements) {
            try {
                indices.add(Integer.parseInt(string) - 1);
            } catch (Exception e) {
                if (string.length() == 1) {
                    char ch = string.toUpperCase().toCharArray()[0];
                    if (Character.isLetter(ch)) {
                        indices.add((int)ch - Constants.LETTER_OFFSET - 1);
                    }
                } else {
                    codes.add(string);
                }
            }
        }
        boolean isIndex = indices != null && indices.size() > 0;
        boolean isCode = codes != null && codes.size() > 0;
        if (!isIndex && !isCode) {
            throw new CommandException();
        }
    }
}

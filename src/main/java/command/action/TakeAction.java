package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.SingleModule;
import exceptions.CommandException;
import exceptions.ItemNotSpecifiedException;

import java.util.ArrayList;

public class TakeAction extends Action {
    private ArrayList<Integer> indices;
    private ArrayList<String> codes;
    boolean isBlind = false;

    @Override
    public String act(Data data) throws Exception {
        String flag = data.flag;
        StringBuilder builder = new StringBuilder();
        if (isBlind) {
            StringBuilder testContent = new StringBuilder();
            data.getTarget(Constants.SELECTED).forEach(x -> {
                if(x instanceof SingleModule) {
                    ((SingleModule)x).isTaken = true;
                    testContent.append(x.getName());
                }
            });
            if (testContent.toString().length() > 0) {
                builder.append("Your selected modules");
            } else {
                builder.append("No modules in your selection.");
            }
        } else {
            if (!indices.isEmpty()) {
                for (int i : indices) {
                    if (i < 0 || i > data.mods.size() - 1) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (data.mods.get(i) instanceof SingleModule) {
                        ((SingleModule)data.mods.get(i)).isTaken = true;
                        builder.append("Module ").append(i + 1).append(": ").
                                append(((SingleModule)data.mods.get(i)).moduleCode).append(Constants.WIN_NEWLINE);
                    }
                }
            }
            if (!codes.isEmpty()) {
                data.mods.stream().filter(x -> codes.contains(((SingleModule)x).moduleCode)).forEach(x -> {
                    ((SingleModule)x).isTaken = true;
                    builder.append("Module: ").append(((SingleModule)x).moduleCode).append(Constants.WIN_NEWLINE);
                });
            }
        }
        data.refreshTarget(flag);
        String result = super.act(data);
        String execution = builder.toString();
        if (execution.equals(Constants.ZERO_LENGTH_STRING)) {
            execution = execution.concat(Constants.NOT_FOUND);
        }
        return result.replace(Constants.TEXT_PLACEHOLDER, execution);
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        indices = new ArrayList<>();
        codes = new ArrayList<>();
        super.prepare(args);
        if (args.thisData == null || flattenedArgs.length < 1) {
            isBlind = true;
            return;
        }
        String[] identifiers = args.thisData.toFlatString().split(Constants.SPACE);
        for (String id : identifiers) {
            try {
                indices.add(Integer.parseInt(id) - 1);
            } catch (Exception e) {
                char ch = id.toUpperCase().toCharArray()[0];
                if (id.length() == 1 && Character.isLetter(ch)) {
                    indices.add((int)ch - Constants.LETTER_OFFSET - 1);
                } else {
                    codes.add(id);
                }
            }
        }
        boolean isCodes = codes != null && codes.size() > 0;
        boolean isIndices = indices != null && indices.size() > 0;
        if (!isBlind && !isCodes && !isIndices) {
            throw new CommandException();
        }
    }
}

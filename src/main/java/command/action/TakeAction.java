package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import exceptions.CommandException;

import java.util.ArrayList;

/**
 * The type Take action.
 */
public class TakeAction extends Action {
    protected ArrayList<Integer> indices;
    protected ArrayList<String> codes;
    protected boolean isBlind = false;

    @Override
    public String act(Data data) throws Exception {
        String flag = data.flag;
        ArrayList<Item> targetBackup = data.target;
        StringBuilder builder = new StringBuilder();
        if (isBlind) {
            StringBuilder testContent = new StringBuilder();
            data.getTarget(Constants.SELECTED).forEach(x -> {
                if (x instanceof SingleModule) {
                    modifyObject(x);
                    testContent.append(getObjectInfo(x)).append(Constants.WIN_NEWLINE);
                }
            });
            if (testContent.toString().length() > 0) {
                builder.append("Your selected modules:").append(Constants.WIN_NEWLINE)
                        .append(testContent.toString());
            } else {
                builder.append("No modules in your selection.");
            }
        } else {
            if (!indices.isEmpty()) {
                for (int i : indices) {
                    if (i < 0 || i > data.mods.size() - 1) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (data.target.get(i) instanceof SingleModule) {
                        Item module = data.target.get(i);
                        modifyObject(module);
                        builder.append("Module ").append(i + 1).append(": ")
                                .append(getObjectInfo(module)).append(Constants.WIN_NEWLINE);
                    } else {
                        builder.append("Item ").append(i + 1).append(" is not a module, "
                                + "therefore cannot be taken or untaken").append(Constants.WIN_NEWLINE);
                    }
                }
            }
            if (!codes.isEmpty()) {
                data.mods.stream().filter(x -> codes.contains(((SingleModule) x).moduleCode)).forEach(x -> {
                    modifyObject(x);
                    builder.append("Module: ").append(getObjectInfo(x)).append(Constants.WIN_NEWLINE);
                });
            }
        }
        data.setFlag(flag);
        data.target = targetBackup;
        String result = super.act(data);
        String execution = builder.toString();
        if (execution.equals(Constants.ZERO_LENGTH_STRING)) {
            execution = execution.concat(Constants.NOT_FOUND);
        }
        return result.replace(Constants.TEXT_PLACEHOLDER, execution);
    }

    protected void modifyObject(Item item) {
        ((SingleModule)item).isTaken = true;
        ((SingleModule)item).grade = "T";
    }

    protected String getObjectInfo(Item item) {
        return item.getName();
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        indices = new ArrayList<>();
        codes = new ArrayList<>();
        super.prepare(args);
        isBlind = false;
        if (args.thisData == null || flattenedArgs.length < 1) {
            safetyCheck();
            return;
        }
        String[] identifiers = args.thisData.toFlatString().split(Constants.SPACE);
        for (String id : identifiers) {
            try {
                indices.add(Integer.parseInt(id) - 1);
            } catch (Exception e) {
                char ch = id.toUpperCase().toCharArray()[0];
                if (id.length() == 1 && Character.isLetter(ch)) {
                    indices.add((int) ch - Constants.LETTER_OFFSET - 1);
                } else {
                    codes.add(id);
                }
            }
        }
        boolean isCodes = codes != null && codes.size() > 0;
        boolean isIndices = indices != null && indices.size() > 0;
        if (!isCodes && !isIndices) {
            throw new CommandException();
        }
    }

    protected void safetyCheck() throws Exception {
        isBlind = true;
    }

    protected String superAct(Data data) throws Exception {
        return super.act(data);
    }
}

package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.SingleModule;
import exceptions.CommandException;

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
            builder.append("Your selected modules");
            data.getTarget(Constants.SELECTED).forEach(x -> {
                if(x instanceof SingleModule) {
                    ((SingleModule)x).isTaken = true;
                }
            });
        } else {
            if (!indices.isEmpty()) {
                for (int i : indices) {
                    if (data.get(i) instanceof SingleModule) {
                        ((SingleModule)data.get(i)).isTaken = true;
                        builder.append("Module ").append(i + 1).append(": ").
                                append(((SingleModule)data.get(i)).moduleCode).append(Constants.WIN_NEWLINE);
                    }
                }
            }
            if (!codes.isEmpty()) {
                data.getTarget(Constants.MOD).forEach(x -> { // always is a module
                    codes.forEach(c -> {
                        if (c.equals(((SingleModule)x).moduleCode)) {
                            ((SingleModule)x).isTaken = true;
                            builder.append("Module: ").append(((SingleModule)x).moduleCode).
                                    append(Constants.WIN_NEWLINE);
                        }
                    });
                });
            }
        }
        data.refreshTarget(flag);
        String result = super.act(data);
        String execution = builder.toString();
        if (execution.equals(Constants.ZERO_LENGTH_STRING)) {
            execution = execution.concat("Target Module Not Found");
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
        if (identifiers.length < 1) {
            isBlind = true;
            return;
        }
        for (String id : identifiers) {
            try {
                indices.add(Integer.parseInt(id) - 1);
            } catch (Exception e) {
                codes.add(id);
            }
        }
        boolean isCodes = codes != null && codes.size() > 0;
        boolean isIndices = indices != null && indices.size() > 0;
        if (!isBlind && !isCodes && !isIndices) {
            throw new CommandException();
        }
    }
}

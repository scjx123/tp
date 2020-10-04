package command.action;

import command.ParamNode;
import constants.Constants;
import data.SingleModule;
import data.TaskList;
import jobs.Task;

import java.util.ArrayList;

public class McAction extends Action {
    private boolean isSelect = false;
    private boolean isDetail = false;
    private boolean isBoth = false;

    private String userInput = "";

    @Override
    public String act(TaskList tasks) {
        StringBuilder builder = new StringBuilder(Constants.MC_HEAD);
        ArrayList<SingleModule> moduleList = new ArrayList<>(tasks.mods);
        if (isSelect) {
            int selectionSum = 0;
            for (SingleModule m : moduleList) {
                selectionSum += Integer.parseInt(m.getModuleMC().trim());
            }
            builder.append(selectionSum).append(Constants.WIN_NEWLINE); //build a string

        } else if (isDetail) {
            for (SingleModule m : moduleList) {
                builder.append(m.getModuleMC().trim()).append(Constants.WIN_NEWLINE);
            }
        } else if (isBoth) {
            for (SingleModule m : moduleList) {
                builder.append(m.getModuleMC().trim()).append(Constants.WIN_NEWLINE);
            }
        } else {
            int sum = 0;
            for (SingleModule m : moduleList) {
                sum += Integer.parseInt(m.getModuleMC().trim());
            }
            builder.append(sum).append(Constants.WIN_NEWLINE); //build a string
        }
        return builder.toString();
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        int len = flattenedArgs.length;
        if (len == 0) {
            isSelect = false;
            isDetail = false;
            isBoth = false;
            userInput = "";
        } else {
            userInput = flattenedArgs[0].toFlatString();
            String[] optionalParams = Constants.optionalParamMap.get(args.name);
            String selection = optionalParams[0];
            String detail = optionalParams[1];
            isSelect = userInput.contains(selection);

            if (isSelect) {
                userInput = flattenedArgs[1].toFlatString();
                if (userInput.contains(detail)) {
                    isBoth = true;
                    isSelect = false;
                    isDetail = false;
                } else {
                    userInput = flattenedArgs[1].toFlatString();
                }
            } else if (userInput.contains(detail)) {
                isDetail = true;
                isBoth = false;
                isSelect = false;
            }
        }
    }
}

package command.action;

import command.Command;
import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import data.jobs.Task;
import exceptions.CommandException;
import exceptions.ModuleNotFoundException;

import java.util.ArrayList;

public class StatsAction extends Action {
    boolean isMod = false;
    String userInput = "";
    String selectedModule;
    SingleModule tempModule = null;
    int doneItem = 0;
    double ratio = 0;

    @Override
    public String act(Data data) throws Exception {
        StringBuilder builder = new StringBuilder(Constants.STATS_HEAD);
        ArrayList<Item> targetList = new ArrayList<>(data.getTarget());

        if (isMod) {
            targetList = new ArrayList<>(data.mods);
            for (Item item : targetList) {
                if (item.getName().toLowerCase().equals(selectedModule.toLowerCase())) {
                    tempModule = (SingleModule)item;
                }
            }
            if (tempModule == null) {
                throw new ModuleNotFoundException();
            }
            for (Item item : tempModule.getTaskList()) {
                Task t = (Task)item;
                if (t.getStatusIcon().equals(Constants.TICK)) {
                    doneItem += 1;
                }
            }
            ratio = (double)doneItem / tempModule.getTaskList().size();
            builder.append(roundedRatioBar(ratio)).append(Constants.WIN_NEWLINE);
        } else {
            if (targetList == null) {
                throw new ModuleNotFoundException();
            } else {
                for (Item item : targetList) {
                    Task t = (Task) item;
                    if (t.getStatusIcon().equals(Constants.TICK)) {
                        doneItem += 1;
                    }
                }
            }
            if (doneItem > 0) {
                ratio = (double) doneItem / targetList.size();
                builder.append(roundedRatioBar(ratio)).append(Constants.WIN_NEWLINE);
            } else if (doneItem == 0) {
                ratio = 0;
                builder.append(roundedRatioBar(ratio)).append(Constants.WIN_NEWLINE);
            }
        }
        return builder.toString();
    }

    private String roundedRatioBar(double fraction) {
        double roundedRatio = Math.round((fraction * 100) * 10) / 10.0;
        return Constants.ICON_LEFT + roundedRatio + Constants.PERCENT + Constants.ICON_RIGHT;
    }

    /**
     * Picking up optional parameter and check if user entered.
     *
     * @param args the args
     * @throws Exception to handle prepare exceptions.
     */
    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        int len = flattenedArgs.length;

        if (len == 0) {
            isMod = false;
            userInput = "";
        } else {
            userInput = flattenedArgs[0].toFlatString();
            String[] optionalParams = Constants.optionalParamMap.get(args.name);
            String mod = optionalParams[0];
            isMod = userInput.contains(mod);

            if (isMod) {
                selectedModule =  userInput.replace("mod","").trim();
                isMod = true;
                userInput = "";
            } else {
                throw new CommandException();
            }
        }
    }
}

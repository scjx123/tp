package command.action;

import command.ParamNode;
import constants.Constants;
import data.Item;
import data.SingleModule;
import data.Data;
import data.jobs.Task;

import java.util.ArrayList;

public class DetailAction extends Action {
    private boolean isMod = false;
    private boolean isTask = false;
    private boolean isCmd = false;
    private String userInput = "";
    private int index = -1;

    @Override
    public String act(Data data) throws Exception {
        StringBuilder builder = new StringBuilder(Constants.DETAIL);
        if (index > 0) { // index reference mode
            Item item = data.get(index);
            builder.append(item.getDetails());
        } else { // find object mode
            if (isMod) {
                ArrayList<Item> mods = data.mods;
                for (Item item : mods) {
                    SingleModule m = (SingleModule)item;
                    if (m.moduleCode.equals(userInput)) {
                        builder.append(m.toString());
                    }
                }
            }
            if (isTask) {
                ArrayList<Item> tasks = data.tasks;
                for (Item item : data.tasks) {
                    Task t = (Task)item;
                    if (t.getDescription().contains(userInput)) {
                        builder.append(t.toString());
                    }
                    builder.append(Constants.WIN_NEWLINE);
                }
            }
        }
        return builder.toString();
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        int len = flattenedArgs.length;
        if (len == 0) {
            isMod = false;
            isTask = false;
            userInput = "";
        } else {
            String argString = flattenedArgs[0].toFlatString();
            String[] optionalParams = Constants.optionalParamMap.get(args.name);
            String mod = optionalParams[0];
            String task = optionalParams[1];
            String command = optionalParams[2];
            isMod = argString.contains(mod);
            isTask = argString.contains(task);
            char[] charArr = flattenedArgs[0].name.toCharArray();
            StringBuilder numBuilder = new StringBuilder();
            for (char c : charArr) {
                if (Character.isDigit(c)) {
                    numBuilder.append(c);
                } else { //if any char is non-numeric, the whole thing is non-numeric
                    numBuilder = new StringBuilder("-1");
                    break;
                }
            }
            index = Integer.parseInt(numBuilder.toString());
            if (index < 1) { // non-numeric
                userInput = flattenedArgs[1].toFlatString();
            }
        }
    }
}

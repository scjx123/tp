package command.action;

import command.ParamNode;
import constants.Constants;
import data.Item;
import data.SingleModule;
import data.Data;
import data.jobs.Task;
import exceptions.ModuleNotFoundException;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class DetailAction extends Action {
    private boolean isMod = false;
    private boolean isTask = false;
    private boolean isCmd = false;
    private String userInput = "";
    private boolean noModule = true;
    private static ArrayList<Item> mods;

    @Override
    public String act(Data data) throws Exception {
        StringBuilder builder = new StringBuilder(Constants.DETAIL + Constants.WIN_NEWLINE);
        if (index > 0) { // index reference mode
            Item item = data.get(index - 1);
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
        }
        return builder.toString();
    }

    @Override
    public void checkError(ParamNode args, Data data) throws ModuleNotFoundException {
        super.checkError(args,data);
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
            if (isMod) {
                userInput = argString.replace("mod","");
            } else if (isTask) {
                userInput = argString.replace("task","");
            }
            checkExist(userInput,data);
        }
    }

    public void checkExist(String moduleToBeChecked,Data data) throws ModuleNotFoundException {
        mods = data.mods;
        for (Item item : mods) {
            SingleModule m = (SingleModule) item;
            if (m.moduleCode.equals(moduleToBeChecked.trim())) {
                noModule = false;
            }
        }
        if (noModule) {
            throw new ModuleNotFoundException();
        }
    }
}

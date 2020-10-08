package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import data.UserData;
import exceptions.ModuleNotFoundException;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The type Add action (on progress).
 */
public class AddAction extends Action {
    private static ArrayList<Item> mods;
    private static int indexOfModule;
    private boolean isMod = false;
    private boolean isTask = false;
    private boolean isCmd = false;
    private String userInput = "";
    private boolean noModule = true;
    private UserData user = new UserData();
    private static int numberOfMods;
    private static StringTokenizer st;

    @Override
    public String act(Data data) {
        StringBuilder builder = new StringBuilder();
        if (isMod) {
            while(st.hasMoreTokens()) {
                getModIndex(userInput);
                SingleModule m = (SingleModule) data.mods.get(indexOfModule);
                if (indexOfModule != -1 && !user.data.containsKey(m)) {
                    user.data.put(data.mods.get(indexOfModule), null);
                    builder.append(Constants.ADD_HEAD).append(Constants.WIN_NEWLINE).append(userInput);
                } else {
                    builder.append(Constants.ITEM_EXIST).append(Constants.WIN_NEWLINE);
                }
            }
        }
        return builder.toString();
    }

    @Override
    public void checkError(ParamNode args, Data data) throws ModuleNotFoundException {
        super.checkError(args, data);
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
                userInput = argString.replace("mod", "");
                //check if user entered multiple mod or a single mod
                st = new StringTokenizer(userInput);
                numberOfMods = st.countTokens();
            } else if (isTask) {
                userInput = argString.replace("task", "");
            }
        }
    }

    public void checkExist(String moduleToBeChecked, Data data) throws ModuleNotFoundException {
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

    public void getModIndex(String moduleCode) {
        for (Item item : mods) {
            SingleModule m = (SingleModule) item;
            if (m.moduleCode.equals(moduleCode.trim())) {
                indexOfModule = mods.indexOf(m);
            }
        }
    }
}

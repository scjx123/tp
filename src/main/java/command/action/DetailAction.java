package command.action;

import command.ParamNode;
import constants.Constants;
import data.Item;
import data.SingleModule;
import data.Data;
import java.util.ArrayList;

public class DetailAction extends Action {
    private boolean isMod = false;
    private boolean isTask = false;
    private boolean isCmd = false;
    private String userInput = "";
    private boolean noModule = true;
    private static ArrayList<Item> mods;
    public StringBuilder builder = new StringBuilder();

    @Override
    public String act(Data data) throws Exception { //data can be list of module or tasks
        ArrayList<Item> mods = data.mods;
        if (isMod) { //user chosen module
            for (Item item : mods) {
                SingleModule m = (SingleModule) item;
                if (m.moduleCode.equals(userInput.trim())) {
                    builder = new StringBuilder(Constants.DETAIL_HEAD);
                    builder.append(m.toString()).append(Constants.WIN_NEWLINE);
                    noModule = false;
                }
            }
            if (noModule) {
                builder.append(Constants.NO_MODULE);
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
            if (isMod) {
                userInput = argString.replace("mod","");
            } else if (isTask) {
                userInput = argString.replace("task","");
            }
        }
    }
}

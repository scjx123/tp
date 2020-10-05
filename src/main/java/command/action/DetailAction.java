package command.action;

import command.ParamNode;
import constants.Constants;
import data.SingleModule;
import data.TaskList;
import jobs.Task;

import java.util.ArrayList;

public class DetailAction extends Action {
    private boolean isMod = false;
    private boolean isTask = false;
    private boolean isCmd = false;
    private String userInput = "";

    @Override
    public String act(TaskList tasks) {
        StringBuilder builder = new StringBuilder(Constants.DETAIL);
        ArrayList<SingleModule> moduleList = new ArrayList<>(tasks.mods);

        if (isMod) {
            for (SingleModule m : moduleList) {
                builder.append(m.getModuleMC() + m.getModuleDescription()
                        + m.getModulePrerequisite()).append(Constants.WIN_NEWLINE);
            }
        }
        if (isTask) {
            for (Task t : tasks.tasks) {
                builder.append(t.getDescription()).append(Constants.WIN_NEWLINE);
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
            userInput = flattenedArgs[0].toFlatString();
            String[] optionalParams = Constants.optionalParamMap.get(args.name);
            String mod = optionalParams[0];
            String task = optionalParams[1];
            String command = optionalParams[2];
            isMod = userInput.contains(mod);
            isTask = userInput.contains(task);
        }
    }
}

package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import exceptions.CommandException;
import exceptions.ModuleNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Grade input action.
 */
public class GradeAction extends TakeAction {

    private HashMap<String, String> modulesWithGrades = new HashMap<>();
    private String option;

    @Override
    public String act(Data data) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        stringBuilder.append(Constants.GRADE_HEAD);

        if (option.equals("a") || option.equals("d") || option.equals("t")) {
            for (Map.Entry<String, String> m : modulesWithGrades.entrySet()) {
                SingleModule module = matchModule(m.getKey(), data.mods);
                if (module == null) {
                    throw new ModuleNotFoundException();
                }
                if (module.isTaken || option.equals("t")) {
                    modifyObject(module, m.getValue());
                    stringBuilder.append(index).append(".").append(Constants.SPACE).append(m.getKey())
                        .append(Constants.TAB)
                        .append(m.getValue().equals("NULL") ? Constants.MOD_NO_GRADE : m.getValue())
                        .append(Constants.WIN_NEWLINE);
                } else {
                    stringBuilder.append(index).append(".").append(Constants.SPACE).append(m.getKey())
                        .append(Constants.TAB).append(Constants.MOD_NOT_TAKEN);
                }
                index++;
            }
        } else if (option.equals("s")) {
            boolean isEmpty = true;

            for (Item item : data.getTarget(Constants.MOD)) {
                SingleModule module = (SingleModule) item;
                if (module.grade != null && !module.grade.isBlank()) {
                    isEmpty = false;
                    String moduleCode = module.moduleCode;
                    String grade = module.grade;
                    if (grade.equals("NULL")) {
                        stringBuilder.append(index).append(".").append(Constants.SPACE).append(moduleCode)
                            .append(Constants.TAB).append(Constants.MOD_NO_GRADE).append(Constants.WIN_NEWLINE);
                    } else {
                        stringBuilder.append(index).append(".").append(Constants.SPACE).append(moduleCode)
                            .append(Constants.TAB).append(grade).append(Constants.WIN_NEWLINE);
                    }
                    index++;
                }
            }

            if (isEmpty) {
                return Constants.NO_MOD_GRADED;
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        option = "s";//set default option
        if (args.thisData == null) {
            return;
        }

        ParamNode currData = flattenedArgs[0];

        //if user input custom option
        if (flattenedArgs[0].name.length() == 1) {
            option = flattenedArgs[0].name.trim();
        }

        currData = currData.thisData;

        //input custom modules
        if (option.equals("a") || option.equals("t")) {
            //match grades to modules
            while (currData != null) {
                String moduleCode = currData.name.toUpperCase().trim();
                String grade = currData.thisData.name.toUpperCase().trim();
                if (!grade.equals("NULL")) {
                    modulesWithGrades.put(moduleCode, grade);
                }
                currData = currData.thisData.thisData;
            }
        } else if (option.equals("s")) {
            //should be do nothing
        } else if (option.equals("d")) {
            //match grades to modules
            while (currData != null) {
                String moduleCode = currData.name.toUpperCase().trim();
                modulesWithGrades.put(moduleCode, "NULL");
                currData = currData.thisData;
            }
        } else {
            //unidentified option
            throw new CommandException();
        }
    }

    protected void modifyObject(Item item, String grade) {
        ((SingleModule) item).grade = grade;
        ((SingleModule) item).isTaken = true;
    }

    /**
     * Match module code to module.
     *
     * @param moduleCode input module code
     * @param mods       module list
     * @return module selected
     */

    private SingleModule matchModule(String moduleCode, ArrayList<Item> mods) {
        for (Item item : mods) {
            SingleModule module = (SingleModule) item;
            if (moduleCode.equals(module.getName())) {
                return module;
            }
        }
        return null;
    }

}

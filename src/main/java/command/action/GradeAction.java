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
public class GradeAction extends Action {

    private HashMap<String, String> modulesWithGrades = new HashMap<>();
    private String option;

    @Override
    public String act(Data data) throws Exception {
        assert data == null : "No data is found";
        StringBuilder stringBuilder = new StringBuilder();
        if (option.equals("a")) {
            for (Map.Entry<String, String> m : modulesWithGrades.entrySet()) {
                String moduleCode = m.getKey();
                SingleModule module = matchModule(moduleCode, data.mods);
                if (module == null) {
                    throw new ModuleNotFoundException();
                }
                if (data.takenCourses == null || !data.takenCourses.contains(module)) {
                    data.takenCourses.add(module);
                }
                module.grade = m.getValue();
            }
            stringBuilder.append(Constants.GRADE_REGISTERED);
        } else if (option.equals("s")) {
            ArrayList<SingleModule> modules = new ArrayList<>();
            for (Item item : data.mods) {
                SingleModule module = (SingleModule) item;
                if (module.grade != null && !module.grade.isBlank()) {
                    modules.add(module);
                }
            }
            stringBuilder.append(Constants.GRADE_HEAD);
            int index = 1;
            for (SingleModule module : modules) {
                String moduleCode = module.moduleCode;
                String grade = module.grade;
                stringBuilder.append(index).append(".").append(Constants.SPACE).append(moduleCode)
                    .append(Constants.TAB).append(grade).append(Constants.WIN_NEWLINE);
                index++;
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

        //input custom modules
        if (option.equals("a")) {
            currData = currData.thisData;
            //match grades to modules
            while (currData != null) {
                String moduleCode = currData.name.toUpperCase().trim();
                String grade = currData.thisData.name.toUpperCase().trim();
                modulesWithGrades.put(moduleCode, grade);
                currData = currData.thisData.thisData;
            }
        } else if (option.equals("s")) {
            //should be do nothing
        } else {
            //unidentified option
            throw new CommandException();
        }
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

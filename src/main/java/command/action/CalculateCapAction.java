package command.action;

import command.ParamNode;
import constants.Constants;

import data.Item;
import data.SingleModule;
import data.Data;
import exceptions.CommandException;
import exceptions.GradeNotSpecifiedException;
import exceptions.ModuleNotFoundException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculate user's cap.
 */
public class CalculateCapAction extends Action {

    private HashMap<String, Double> modulesWithGrades = new HashMap<>();
    private String option;

    @Override
    public String act(Data data) throws Exception {
        double totalScore = 0;
        double totalMC = 0;
        double gradeValue;
        if (option.equals("m")) {
            for (Map.Entry<String, Double> m : modulesWithGrades.entrySet()) {
                gradeValue = m.getValue();
                String moduleCode = m.getKey();
                SingleModule module = matchModule(moduleCode, data.mods);
                if (module == null) {
                    throw new ModuleNotFoundException();
                }
                totalMC += Double.parseDouble(module.getModuleMC());
                totalScore += Double.parseDouble(module.getModuleMC()) * gradeValue;
            }
        } else if (option.equals("u")) {
            boolean isNew = true;
            for (Item item : data.mods) {
                SingleModule module = (SingleModule) item;
                if (module.isTaken) {
                    isNew = false;
                    if (module.grade == null) {
                        throw new GradeNotSpecifiedException();
                    }
                    gradeValue = numerateGrade(module.grade.toUpperCase());
                    totalMC += Double.parseDouble(module.getModuleMC());
                    totalScore += Double.parseDouble(module.getModuleMC()) * gradeValue;
                }
            }

            if (isNew) {
                return Constants.COURSE_NOT_SPEC;
            }
        }
        double capValue = totalScore / totalMC;
        return Constants.SHOW_CAP + new DecimalFormat("#.##").format(capValue);
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        option = "u";

        if (args.thisData == null) {
            return;
        }

        ParamNode currData = flattenedArgs[0];
        option = flattenedArgs[0].name;

        //input custom modules
        if (option.equals("m")) {
            while (currData.thisData != null) {
                String moduleCode = currData.thisData.name.toUpperCase();
                Double grade = numerateGrade(currData.thisData.thisData.name.toUpperCase());
                modulesWithGrades.put(moduleCode, grade);
                currData = currData.thisData.thisData;
            }
        } else if (option.equals("u")) {
            return;
        } else {
            throw new CommandException();
        }
    }

    /**
     * Match module code to module.
     *
     * @param moduleCode input module code
     * @param mods module list
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

    /**
     * Turn grade alphabet to numbers.
     *
     * @param grade grade alphabet
     * @return grade value in number
     */
    private double numerateGrade(String grade) throws GradeNotSpecifiedException {
        double gradeValue;
        switch (grade) {
        case "A+":
        case "A":
            gradeValue = 5;
            break;
        case "A-":
            gradeValue = 4.5;
            break;
        case "B+":
            gradeValue = 4;
            break;
        case "B":
            gradeValue = 3.5;
            break;
        case "B-":
            gradeValue = 3;
            break;
        case "C+":
            gradeValue = 2.5;
            break;
        case "C":
            gradeValue = 2;
            break;
        case "D+":
            gradeValue = 1.5;
            break;
        case "D":
            gradeValue = 1;
            break;
        default:
            throw new GradeNotSpecifiedException();
        }
        return gradeValue;
    }
}
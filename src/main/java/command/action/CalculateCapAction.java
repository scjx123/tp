package command.action;

import command.ParamNode;
import constants.Constants;

import data.Item;
import data.SingleModule;
import data.Data;
import exceptions.CommandException;
import exceptions.ModuleNotFoundException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculate user's cap.
 */
public class CalculateCapAction extends Action {

    protected HashMap<String, Double> modulesWithGrades = new HashMap<>();
    protected String option;
    protected double totalScore = 0;
    protected double totalMC = 0;

    @Override
    public String act(Data data) throws Exception {
        totalScore = 0;
        totalMC = 0;
        if (option.equals("m")) {
            for (Map.Entry<String, Double> m : modulesWithGrades.entrySet()) {
                String moduleCode = m.getKey();
                SingleModule module = matchModule(moduleCode, data.mods);
                if (module == null) {
                    return Constants.MOD_NOT_FOUND;
                }

                double gradeValue = m.getValue();
                if (gradeValue == -1) {
                    return Constants.GRADE_NOT_FOUND;
                }

                totalMC += Double.parseDouble(module.getModuleMC());
                totalScore += Double.parseDouble(module.getModuleMC()) * gradeValue;
            }
        } else if (option.equals("u")) {
            if (checkCalculateCap(data)) {
                return Constants.MODULE_GRADE_CORRUPT;
            }
        }
        double capValue = totalScore / totalMC;
        return Constants.SHOW_CAP + new DecimalFormat("#.##").format(capValue);
    }

    /**
     * Calculate user totalScore and totalMC.
     */
    protected boolean checkCalculateCap(Data data) {
        boolean isNotSpec = true;
        double gradeValue;
        totalScore = 0;
        totalMC = 0;

        for (Item item : data.mods) {
            SingleModule module = (SingleModule) item;
            if (module.isTaken && module.grade != null) {
                isNotSpec = false;
                gradeValue = numerateGrade(module.grade.toUpperCase());
                totalMC += Double.parseDouble(module.getModuleMC());
                totalScore += Double.parseDouble(module.getModuleMC()) * gradeValue;
            }
        }
        return isNotSpec;
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        modulesWithGrades.clear();
        option = "u";

        if (args.thisData == null) {
            return;
        }

        ParamNode currData = flattenedArgs[0];
        option = flattenedArgs[0].name;

        //input custom modules
        if (option.equals("m")) {
            while (currData.thisData != null) {
                if (currData.thisData.thisData == null) {
                    throw new CommandException();
                }
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
     * @return numeric grade value
     */
    private double numerateGrade(String grade) {
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
        case "F":
            gradeValue = 0;
            break;
        default:
            return -1;
        }
        return gradeValue;
    }
}
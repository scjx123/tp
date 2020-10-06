package command.action;

import command.ParamNode;
import constants.Constants;

import data.SingleModule;
import data.TaskList;
import exceptions.ModuleNotFoundException;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculate user's cap.
 */
public class CalculateCapAction extends Action {

    private final HashMap<SingleModule, Double> modulesWithGrades = new HashMap<>();

    private double capValue = 0;

    @Override
    public String act(TaskList tasks) {
        double totalScore = 0;
        double totalMC = 0;
        for (Map.Entry<SingleModule, Double> m : modulesWithGrades.entrySet()) {
            Double grade = m.getValue();
            SingleModule module = m.getKey();
            totalMC += Double.parseDouble(module.getModuleMC());
            totalScore += Double.parseDouble(module.getModuleMC()) * grade;
        }

        capValue = totalScore / totalMC;
        return Constants.SHOW_CAP + new DecimalFormat("#.##").format(capValue);
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        ParamNode currData;

        //extract modules name
        currData = flattenedArgs[0];
        //input custom modules
        if (flattenedArgs[0].name.equals("m")) {
            while (currData.thisData != null) {
                SingleModule module;
                String moduleCode = currData.thisData.name.toUpperCase();
                Double grade = numerateGrade(currData.thisData.thisData.name.toUpperCase());
                module = matchModule(moduleCode);
                modulesWithGrades.put(module, grade);
                currData = currData.thisData.thisData;
            }
        } else {
            // retrieve module data from user data
        }
    }

    private SingleModule matchModule(String moduleCode) throws ModuleNotFoundException {
        for (SingleModule module : TaskList.mods) {
            if (moduleCode.equals(module.getName())) {
                return module;
            }
        }
        throw new ModuleNotFoundException();
    }

    /**
     * Turn grade alphabet to numbers.
     *
     * @param grade grade alphabet
     * @return grade value in number
     */
    private double numerateGrade(String grade) {
        double gradeValue = 0;
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
            gradeValue = 0;
            break;
        }
        return gradeValue;
    }
}

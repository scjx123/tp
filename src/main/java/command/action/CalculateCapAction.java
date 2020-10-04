package command.action;

import command.ParamNode;
import constants.Constants;
import data.ParentModules;
import static data.ParentModules.moduleList;

import data.SingleModule;
import messages.MessageOptions;

import java.util.ArrayList;

/**
 * Calculate user's cap
 */
public class CalculateCapAction extends Action {

    private ArrayList<Double> grades = new ArrayList<>();
    private ArrayList<String> moduleNames = new ArrayList<>();
    private ArrayList<SingleModule> modules = new ArrayList<>();
    private double capValue = 0;

    @Override
    public String act(ParentModules parentModules) {
        int gradeIndex = 0;
        double totalScore = 0;
        double totalMC = 0;
        for (SingleModule module : modules) {
            totalMC += Double.parseDouble(module.getModuleMC());
            totalScore += Double.parseDouble(module.getModuleMC()) * (grades.get(gradeIndex));
            gradeIndex++;
        }
        capValue = totalMC / totalScore;
        return Constants.SHOW_CAP + capValue;
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        ParamNode currData;
        super.prepare(args);

        //extract modules name
        currData = flattenedArgs[1];
        if (currData.name.equals("m")) {
            while (currData.thisData != null) {
                moduleNames.add(currData.thisData.name);
                currData = currData.thisData;
            }
        }

        int i=0;
        for (String moduleName: moduleNames){
            if(moduleName.equals(moduleList))
        }
        for(SingleModule module : moduleList){
            if(module.equals(moduleNames.get(i)))
            modules.add()
        }
        modules = (ArrayList<SingleModule>) moduleList.stream()
                .map(module -> moduleNames.stream()
                        .filter(moduleName -> moduleName.equals(module.getName())));

        //extract module grades
        currData = flattenedArgs[2];
        if (currData.name.equals("g")) {
            while (currData.thisData != null) {
                grades.add(numerateGrade(currData.thisData.name));
                currData = currData.thisData;
            }
        }
    }

    /**
     * Turn grade alphabet to numbers
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

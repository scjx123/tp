package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import data.SingleModule;
import exceptions.TooManyArgumentsException;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Goal planner function.
 */
public class GoalAction extends CapAction {

    double takenMC;
    double takenCap;
    double targetMC;
    double targetCap;
    boolean isDefault = true;

    @Override
    public String act(Data data) throws Exception {
        double goalScore = targetMC * targetCap;
        double currentScore = takenMC * takenCap;
        if (isDefault) {
            double takenGrade = 0;
            double totalTakenMC = 0;
            double totalCapMC = 0;
            ArrayList<Item> targetBackup = data.target;
            String flagBackup = data.flag;
            for (Item item : data.getTarget(Constants.CAP_DATA)) {
                String currentGrade = filterGrade(((SingleModule)item).grade);
                String score = currentGrade == null ? "U" : currentGrade;
                double mc = 0;
                try {
                    mc = Double.parseDouble(((SingleModule) item).getModuleMC());
                } catch (Exception e) {
                    throw new Exception("One of your taken modules has invalid grade.");
                }
                if (!score.equals("U")) {
                    takenGrade += parseGrade(score) * mc;
                    totalTakenMC += mc;
                    if (!score.equals("S")) {
                        totalCapMC += mc;
                    }
                }
            }
            takenCap = takenGrade / totalCapMC;
            takenMC = totalTakenMC;
            currentScore = takenGrade;
        }
        if ((targetMC - takenMC) <= 0) {
            return Constants.CAN_GRADUATE;
        }
        double capRequired = (goalScore - currentScore) / (targetMC - takenMC);
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.REQUIRED_CAP).append(new DecimalFormat("#.##")
                .format(capRequired)).append(Constants.WIN_NEWLINE);
        if (capRequired < 0) {
            sb.append(Constants.WORK_LESS);
        } else if (capRequired <= 1.0) {
            sb.append(Constants.LOW_CAP);
        } else if (capRequired <= 5.0) {
            sb.append(Constants.JIAYOU);
        } else {
            sb.append(Constants.HIGH_CAP);
        }
        return sb.toString();
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        targetMC = 0;
        targetCap = 0;
        takenMC = 0;
        takenCap = 0;
        isDefault = true;
        if (flattenedArgs.length > 2) {
            throw new TooManyArgumentsException();
        }
        try {
            targetMC = Double.parseDouble(flattenedArgs[0].thisData.toString());
            targetCap = Double.parseDouble(flattenedArgs[0].nextData.toString());
            if (flattenedArgs.length == 2) {
                isDefault = false;
                takenMC = Double.parseDouble(flattenedArgs[1].thisData.toString());
                takenCap = Double.parseDouble(flattenedArgs[1].nextData.toString());
            }
        } catch (Exception e) {
            throw new Exception("Number is not parsable. Did you make a typo?");
        }
        if (takenMC < 0) {
            throw new Exception("Your taken MC cannot be negative!");
        }
        if (takenCap < 0) {
            throw new Exception("Your taken CAP cannot be negative!");
        } else if (takenCap > 5) {
            throw new Exception("Your taken CAP cannot be higher than 5.0!");
        }
        if (targetMC < 0) {
            throw new Exception("Your total MC required cannot be negative!");
        }
        if (targetCap < 0) {
            throw new Exception("Your target CAP cannot be negative!");
        } else if (targetCap > 5) {
            throw new Exception("Your target CAP cannot be higher than 5.0!");
        }
    }
}
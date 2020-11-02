package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import exceptions.CommandException;

import java.text.DecimalFormat;

/**
 * Goal planner function.
 */
public class GoalAction extends CalculateCapAction {

    String option;
    double targetCap;
    double mcGraduate;

    @Override
    public String act(Data data) throws Exception {
        double totalScoreGoal = mcGraduate * targetCap;
        if (option.equals("u")) {
            checkCalculateCap(data);
        }

        if ((mcGraduate - totalMC) <= 0) {
            return Constants.CAN_GRADUATE;
        }

        double capRequired = (totalScoreGoal - totalScore) / (mcGraduate - totalMC);
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.REQUIRED_CAP + new DecimalFormat("#.##").format(capRequired) + Constants.WIN_NEWLINE);
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

        if (args.thisData == null) {
            return;
        }

        ParamNode currData = args.thisData;
        option = currData.name;

        if (currData == null || currData.thisData == null || currData.thisData.thisData == null) {
            throw new CommandException();
        }

        mcGraduate = Integer.parseInt(currData.thisData.name);
        targetCap = Double.parseDouble(currData.thisData.thisData.name);

        //input custom mc and cap
        if (option.equals("c")) {
            currData = currData.thisData.thisData;

            if (currData.thisData == null || currData.thisData.thisData == null) {
                throw new CommandException();
            }

            totalMC = Double.parseDouble(currData.thisData.name);
            double currentCap = Double.parseDouble(currData.thisData.thisData.name);
            totalScore = currentCap * totalMC;
        } else if (option.equals("u")) {
            //do nothing
        } else {
            throw new CommandException();
        }
    }
}
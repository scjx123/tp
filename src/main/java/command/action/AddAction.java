package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;

import java.util.ArrayList;

/**
 * The type Add action (on progress).
 */
public class AddAction extends Action {

    private ArrayList<String> taskNames;
    private ArrayList<String> modNames;

    @Override
    public String act(Data data) throws Exception {
        // do stuff
        return "";
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        for (ParamNode arg : flattenedArgs) {
            if (arg.name.equals(Constants.MOD)) {
                modNames.add(arg.toFlatString());
            } else if (arg.name.equals(Constants.TASK)) {
                modNames.add(arg.toFlatString());
            }
        }
    }
}

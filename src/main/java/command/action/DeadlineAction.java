package command.action;

import command.ParamNode;
import data.ClashChecker;
import data.Data;
import data.jobs.Deadline;

/**
 * The type Deadline action.
 */
public class DeadlineAction extends Action {

    private String description;
    private String by;

    @Override
    public String act(Data data) throws Exception {
        String result = super.act(data);
        Deadline ddl = new Deadline(description, by);
        data.addTask(ddl);
        return replaceStrings(result, ddl.toString(), data.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        by = flattenedArgs[1].thisData.toFlatString();
        description = flattenedArgs[0].toFlatString();
    }
}

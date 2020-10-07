package command.action;

import command.ParamNode;
import data.Data;
import jobs.Event;

/**
 * The type Event action.
 */
public class EventAction extends Action {

    private String description;
    private String at;

    @Override
    public String act(Data data) {
        String result = super.act(data);
        Event event = new Event(description, at);
        data.addTask(event);
        return replaceStrings(result, event.toString(), data.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        at = flattenedArgs[1].thisData.toFlatString();
        description = flattenedArgs[0].toFlatString();
    }
}

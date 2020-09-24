package command;

import java.util.HashMap;

public class CommandResult {

    public String description = "";
    private HashMap<Object, Object> data = null;

    public CommandResult(String description) {
        this.description = description;
    }

    public HashMap<Object, Object> getData() {
        return data;
    }
}

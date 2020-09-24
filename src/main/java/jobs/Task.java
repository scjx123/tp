package jobs;

import constants.Constants;
import data.Item;

public class Task extends Item {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        super(description);
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? Constants.TICK : Constants.CROSS);
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsUndone() {
        isDone = false;
    }
}

package jobs;

import constants.Constants;
import exceptions.CommandException;
import data.Item;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The type Task.
 */
public class Task extends Item{

    /**
     * The Is done.
     */
    protected boolean isDone;


    /**
     * Instantiates a new Task.
     *
     * @param description the description
     */
    public Task(String description) {
        super(description);
        this.isDone = false;
        this.description = description;
        dateTime = null;
        isDated = false;
    }



    /**
     * Gets description of the task.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Get status icon string.
     *
     * @return the string
     */
    public String getStatusIcon() {
        return (isDone ? Constants.TICK : Constants.CROSS);
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Mark as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Mark as undone.
     */
    public void markAsUndone() {
        isDone = false;
    }
}

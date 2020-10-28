//@@author TomLBZ

package data.jobs;

import constants.Constants;

/**
 * The type Event.
 */
public class Event extends Task {

    /**
     * The At.
     */
    protected String at;

    /**
     * Instantiates a new Event.
     *
     * @param description the description
     * @param at          the at
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        setDateTime(at);
    }

    @Override
    public String toString() {
        String atTime = getDateTimeString(at);
        if (isWeekly) {
            return Constants.EVENT_ICON + super.toString() + " (at: " + atTime + ")" + " Weekly";
        } else {
            return Constants.EVENT_ICON + super.toString() + " (at: " + atTime + ")";
        }
    }
}

//@@author TomLBZ

package data.jobs;

import constants.Constants;

/**
 * The type Deadline.
 */
public class Deadline extends Task {

    /**
     * Deadline due time.
     */
    protected String by;

    /**
     * Instantiates a new Deadline.
     *
     * @param description deadline description
     * @param by          deadline due time
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        setDateTime(by);
    }

    @Override
    public String toString() {
        String byTime = getDateTimeString(by);
        if (isWeekly) {
            return Constants.DDL_ICON + super.toString() + " (by: " + byTime + ")" + " Weekly";
        } else {
            return Constants.DDL_ICON + super.toString() + " (by: " + byTime + ")";
        }
    }

}

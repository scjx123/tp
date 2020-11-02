//@author: johanesrafael
package command.action;

import constants.Constants;

/**
 * The type Snooze action.
 */
public class SnoozeAction extends Action {

    private String newInterval;
    private String addDefaultDelay = "60000"; // default delay for Snooze

    public SnoozeAction() {
        super();
    }

    public String getNewInterval() {
        newInterval = Integer.toString(Integer.parseInt(Constants.REMINDER_INTERVAL)
                + Integer.parseInt(addDefaultDelay));
        return newInterval;
    }
}

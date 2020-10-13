package command.action;

import constants.Constants;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReminderActionTest {

    @Test
    public void act_reminderInput_testOutput() {
        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
        assertTrue(d.testOutputSut("reminder").contains(Constants.REMINDER_HEAD));
    }
}
package command.action;

import constants.Constants;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Focus Action Test.
 */
class FocusActionTest {
    private String[] testCommand = {"focus", "focus deadline", "focus todo", "focus event"};

    @Test
    void act_customFocusInput_focussedlist() {
        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
        assertAll("testCommand", () -> assertTrue(d.testSut(testCommand[0]).contains(Constants.NO_TASK_TYPE)),
            () -> assertTrue(d.testSut(testCommand[1]).contains("by")),
            () -> assertTrue(d.testSut(testCommand[2]).contains("T")),
            () -> assertTrue(d.testSut(testCommand[3]).contains("at"))
        );

    }
    
}
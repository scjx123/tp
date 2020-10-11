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
    private String[] testCommand = {"focus", "focus deadline", "focus todo", "focus event", "focus task",
                                    "focus mod", "focus selected", "focus taken", "focus asdsds"};

    @Test
    void act_customFocusInput_testOutput() {
        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
        assertAll("FocusActionTest",
            () -> assertTrue(d.testOutputSut(testCommand[0]).equals("Now we are focusing on:\r\ntask")),
            () -> assertTrue(d.testOutputSut(testCommand[1]).equals("Now we are focusing on:\r\ndeadline")),
            () -> assertTrue(d.testOutputSut(testCommand[2]).equals("Now we are focusing on:\r\ntodo")),
            () -> assertTrue(d.testOutputSut(testCommand[3]).equals("Now we are focusing on:\r\nevent")),
            () -> assertTrue(d.testOutputSut(testCommand[4]).equals("Now we are focusing on:\r\ntask")),
            () -> assertTrue(d.testOutputSut(testCommand[5]).equals("Now we are focusing on:\r\nmod")),
            () -> assertTrue(d.testOutputSut(testCommand[6]).equals("Now we are focusing on:\r\nselected")),
            () -> assertTrue(d.testOutputSut(testCommand[7]).equals("Now we are focusing on:\r\ntaken")),
            () -> assertTrue(d.testOutputSut(testCommand[8]).equals("Invalid Command! Please check the syntax.\r\n"
                    + "focus    OR    focus [deadline / todo / event / task / mod / selected / taken]"))
        );
    }
}
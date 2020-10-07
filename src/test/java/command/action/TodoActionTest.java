package command.action;


import constants.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import seedu.duke.Duke;

/**
 * Module Credits Test.
 */
public class TodoActionTest {

    private String[] testCommand = {"todo abc", "todo def"};

    @Test
    public void act_todoCommandsInputs_todoCreated() {
        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);

        assertAll("TodoActionTest", () -> assertTrue(d.testSut(testCommand[0]).contains("abc")),
            () -> assertTrue(d.testSut(testCommand[1]).contains("def"))
        );
    }
}

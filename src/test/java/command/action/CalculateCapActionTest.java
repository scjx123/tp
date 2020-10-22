package command.action;

import constants.Constants;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

/**
 * Test for CAP calculator.
 */
class CalculateCapActionTest {

    private Duke duke = new Duke(false, System.out, System.in, Constants.PATH,
        Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);

    @Test
    public void act_customModuleInputs_calculatedCapValue() {
        duke.testSut("clear", true, false);
        String expectedOutput = "Here is your existing CAP: 3.67";
        String testCustomInputsCommand = "cap -m cs1231 a MA1511 B+ Cs2040C d ma1508e a- ee1001x b+";
        assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand, false, true),
            "Calculate CAP custom input fails");
    }

    @Test
    public void act_userModule_calculatedCapValue() {
        duke.testSut("clear", true, false);
        duke.testSut("grade -t cs1231 a cs1010 b ma1511 c+", true, false);
        String expectedOutput = "Here is your existing CAP: 3.9";
        String testInputsCommand = "cap";
        assertEquals(expectedOutput, duke.testSut(testInputsCommand, false, true),
            "Calculate CAP user's modules fails");
    }
}


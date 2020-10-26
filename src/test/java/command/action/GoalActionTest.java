package command.action;

import constants.Constants;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

class GoalActionTest {
    Duke duke = new Duke(false, System.out, System.in, Constants.PATH,
        Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);

    @Test
    public void act_normalUserData_calculatedCAP() {
        duke.testSut("focus list", false, false);
        duke.testSut("clear", true, false);
        duke.testSut("grade -t Cs2040C d ma1508e a- ee1001x b+", true, false);
        String expectedOutput = "Your required average CAP is: 4.78\r\n" + "Jia you! :D\r\n";
        String testCustomInputsCommand = "goal -u 100 4.5";
        assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand, false, true),
            "Goal normal_user_data fails");
    }

    @Test
    public void act_normalCustomData_calculatedCAP() {
        String expectedOutput = "Your required average CAP is: 4.62\r\n" + "Jia you! :D\r\n";
        String testCustomInputsCommand = "goal -c 100 4.5 20 4";
        assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand, false, true),
            "Goal normal_custom_data fails");
    }
}
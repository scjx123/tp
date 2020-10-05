package command.action;

import constants.Constants;
import data.ParentModules;
import data.SingleModule;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

import java.util.HashMap;

/**
 * Test for CAP calculator.
 */
class CalculateCapActionTest {

    private Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);

    @Test
    public void act_customModuleInputs_calculatedCapValue() {
        String testModulesWithGrades = "cs1231 a MA1511 B+ Cs2040C d";
        String expectedOutput = "Here is your existing CAP: 3.2";
        String testCustomInputsCommand = "cap -m " + testModulesWithGrades;
        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Calculate CAP custom input fails");
    }
}
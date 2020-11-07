package command.action;

import constants.Constants;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import seedu.duke.Domsun;

/**
 * Test for CAP calculator.
 */

class CapActionTest {

    private Domsun domsun = new Domsun(false, System.out, System.in, Constants.PATH,
        Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);

    @Test
    public void act_customModuleInputs_calculatedCapValue() {
        String expectedOutput =
            "Calculate cap on specified modules:\r\n"
                + "Module: CG1112: (hypothetical)A-\r\n"
                + "Module: CS2113: (hypothetical)A\r\n"
                + "CAP = 4.7";
        String testCustomInputsCommand = "cap CS2113 A CG1112 A-";
        assertAll("Cap action test",
            () -> assertEquals(expectedOutput, domsun.testSut(testCustomInputsCommand, false, true),
                "Custom input grade and modules")
        );
    }
    /*
    @Test
    public void act_userModule_calculatedCapValue() throws Exception {
        int[] indices = {1, 2, 3};
        String[] grades = {"A", "B", "C"};
        for (int index : indices) {
            SingleModule module = (SingleModule) dataTest.mods.get(index);
            module.isTaken = true;
            module.grade = grades[index - 1];
        }
        CapAction action = new CapAction();
        action.option = "u";
        String expectedOutput = "Here is your existing CAP: 3.5";
        assertEquals(expectedOutput, action.act(dataTest), "Calculate CAP user's modules fails");
    }
    */
}
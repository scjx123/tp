//package command.action;
//
//import constants.Constants;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.Test;
//import seedu.duke.Duke;
//
///**
// * Test for CAP calculator.
// */
//class CalculateCapActionTest {
//
//    private Duke duke = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
//
//    @Test
//    public void act_customModuleInputs_calculatedCapValue() {
//        String expectedOutput = "Here is your existing CAP: 3.67";
//        String testCustomInputsCommand = "cap -m cs1231 a MA1511 B+ Cs2040C d ma1508e a- ee1001x b+";
//        assertEquals(expectedOutput, duke.testOutputSut(testCustomInputsCommand), "Calculate CAP custom input fails");
//    }
//}
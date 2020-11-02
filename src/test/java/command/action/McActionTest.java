//package command.action;
//
//import constants.Constants;
//import org.junit.jupiter.api.Test;
//import seedu.duke.Domnus;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//
///**
// * Module Credits Test.
// */
//public class McActionTest {
//
//    private String[] testCommand = {"mc", "mc -d", "mc -p", "mc -d -p"};
//
//    @Test
//    public void act_moduleCommandsInputs_suitableMcDisplayed() {
//        Domnus d = new Domnus(false, System.out, System.in, Constants.PATH,
//            Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);
//
//        assertAll("McActionTest", () -> assertTrue(d.testSut(testCommand[0], false, true)
//                .contains("48788")),
//            () -> assertTrue(d.testSut(testCommand[1], false, true).contains("12"))
//        );
//    }
//
//    @Test
//    public void mcAction_ExceptionInput_PrintInvalidCommand() {
//        Domnus d = new Domnus(false, System.out, System.in, Constants.PATH,
//            Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);
//        assertTrue(() -> d.testSut(testCommand[2], false, true).contains(Constants.INVALID));
//        assertTrue(() -> d.testSut(testCommand[3], false, true).contains(Constants.INVALID));
//    }
//
//}

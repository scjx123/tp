//package command.action;
//
//import constants.Constants;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;
//import seedu.duke.Domsun;
//
//class PostponeActionTest {
//
//    private String[] testCommand = {"postpone", "postpone 1", "postpone 5", "postpone h 5", "postpone a 5"};
//
//    @Test
//    void act_postponeInput_testOutput() {
//        Domsun d = new Domsun(false, System.out, System.in, Constants.PATH,
//            Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);
//
//        assertAll("PostponeActionTest",
//            () -> assertTrue(d.testSut(testCommand[0], true, true)
//                    .contains(Constants.INDEX_OUT)),
//            () -> assertTrue(d.testSut(testCommand[1], true, true)
//                    .contains(Constants.NOT_DEADLINE_OR_EVENT)),
//            () -> assertTrue(d.testSut(testCommand[2], true, true)
//                    .contains("I've postpone this task:")),
//            () -> assertTrue(d.testSut(testCommand[3], true, true)
//                    .contains("I've postpone this task:")),
//            () -> assertTrue(d.testSut(testCommand[4], true, true)
//                    .contains("Invalid Command! Please check the syntax.\r\n"
//                    + "postpone [index]    OR    postpone [h / w / y] [index]"))
//        );
//    }
//}
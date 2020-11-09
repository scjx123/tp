package command.action;

import constants.Constants;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import seedu.duke.Domsun;

class PostponeActionTest {

    private Domsun domsun = new Domsun(false, System.out, System.in, Constants.PATH,
        Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);

    @Test
    void act_postponeInput_respondMessage() {
        domsun.testSut("clear", true, true);
        domsun.testSut("todo eat banana while watching Minions s4", false, false);
        domsun.testSut("deadline watch Spongebob roundpants s3 -by 22-01-2001 12:00", false, false);

        String[] testCommand = {
            "postpone", "postpone 1", "postpone 2", "postpone w 2",
        };
        String[] expectedOutput = {
            "Invalid Command! Please check the syntax.\r\n"
                + "    postpone [index]\r\n"
                + "    postpone (h / w / y) [index]\r\n",

            "Sorry, there is no date in todo task!\r\n",

            "I've postpone this task:\r\n"
                + "[D][X] watch Spongebob roundpants s3 (by: Jan 23 2001 12:00)",

            "I've postpone this task:\r\n"
                + "[D][X] watch Spongebob roundpants s3 (by: Jan 30 2001 12:00)",
        };

        assertAll("PostponeActionTest",
            () -> assertTrue(domsun.testSut(testCommand[0], true, true)
                .contains(expectedOutput[0]), "Invalid command"),
            () -> assertEquals(expectedOutput[1], domsun.testSut(testCommand[1], false, true),
                "Invalid task type (todo)"),
            () -> assertEquals(expectedOutput[2], domsun.testSut(testCommand[2], false, true),
                "Normal input default"),
            () -> assertEquals(expectedOutput[3], domsun.testSut(testCommand[3], false, true),
                "Normal input week")
        );
        domsun.testSut("clear", true, true);
    }
}
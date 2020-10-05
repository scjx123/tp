package command.action;

import constants.Constants;
import data.TaskList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

/**
 * Tests for various task actions:
 *  Clear, deadline, todo, event,
 */
class TasksActionTest {

    private Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);

    @Test
    public void actClear_normalCase_clearResponseMessage() {
        String expectedOutput = "Nice! I've cleared everything in the list.";
        String testCustomInputsCommand = "clear";

        assertAll("McActionTest",
            () -> assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Clear fails"),
            () -> assertTrue(TaskList.tasks.size() == 0)
        );
    }

    @Test
    public void actDeadline_randomByTime_customTimeDeadline() {
        Integer prevListSize = TaskList.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n" +
            "[D][X] watch powerRangers episode 2 (by: TODAY!!)\r\n" +
            "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "deadline watch powerRangers episode 2 -by TODAY!!";
        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Deadline custom time inputs fails");
    }

    @Test
    public void actDeadline_dateTimeFormat_formattedTimeDeadline() {
        Integer prevListSize = TaskList.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n" +
            "[D][X] watch powerRangers episode 3 (by: Feb 23 2022 09:00)\r\n" +
            "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "deadline watch powerRangers episode 3 /by 2022-02-23 09:00";
        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Deadline format time inputs fails");
    }

    @Test
    public void actTodo_normalTodo_todoRespondMessage() {
        Integer prevListSize = TaskList.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n" +
            "[T][X] finish CS2113 Project!\r\n" +
            "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "todo finish CS2113 Project!";
        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Todo normal inputs fails");
    }

    @Test
    public void actEvent_randomAtTime_customTimeDeadline() {
        Integer prevListSize = TaskList.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n" +
            "[E][X] watch Dora The Explorer episode 2 (at: your Free Time :))\r\n" +
            "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "event watch Dora The Explorer episode 2 -at your Free Time :)";
        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Event custom time inputs fails");
    }

//    @Test
//    public void actEvent_dateTimeFormat_formattedTimeDeadline() {
//        Integer prevListSize = TaskList.tasks.size();
//        String updatedListSize = Integer.toString(prevListSize + 1);
//        String expectedOutput = "Got it. I've added this task:\r\n" +
//            "[E][X] watch Dora The Explorer episode 3 (at: Feb 23 2022)\r\n" +
//            "Now you have " + updatedListSize + " tasks in the list.";
//        String testCustomInputsCommand = "event watch Dora The Explorer episode 3 /at 2022-02-23";
//        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "Event format time inputs fails");
//    }

//    @Test
//    public void actList_filledList_listResponseMessage() {
//        String expectedOutput = "Here is the list of tasks:\r\n" +
//            "1.[E][X] watch Dora The Explorer episode 3 (at: Feb 23 2022 00:00)\r\n" +
//            "2.[T][X] finish CS2113 Project!\r\n" +
//            "3.[D][X] watch powerRangers episode 3 (by: Feb 23 2022 09:00)\r\n" +
//            "4.[E][X] watch Dora The Explorer episode 3 (at: Feb 23 2022 00:00)";
//        String testCustomInputsCommand = "list";
//        assertEquals(expectedOutput, d.testSut(testCustomInputsCommand), "List fails");
//    }
}
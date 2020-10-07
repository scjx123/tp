package command.action;

import constants.Constants;
import data.TaskList;
import jobs.Deadline;
import jobs.Event;
import jobs.ToDo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

/**
 * Tests for various task actions.
 */
class TasksActionTest {

    private Duke duke = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);

    @Test
    public void actClear_normalCase_clearResponseMessage() {
        String expectedOutput = "Nice! I've cleared everything in the list.";
        String testCustomInputsCommand = "clear";

        assertAll("McActionTest",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand), "Clear fails"),
            () -> assertTrue(Data.tasks.size() == 0)
        );
    }

    @Test
    public void actDeadline_randomByTime_customTimeDeadline() {
        Integer prevListSize = Data.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n"
            + "[D][X] watch powerRangers episode 2 (by: TODAY!!)\r\n"
            + "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "deadline watch powerRangers episode 2 -by TODAY!!";
        assertAll("Deadline random time",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand),
                "Deadline custom time inputs fails"),
            () -> assertTrue(TaskList.tasks.get(prevListSize).getDescription().equals("watch powerRangers episode 2"))
        );
        TaskList.tasks.remove(TaskList.tasks.get(prevListSize));
    }

    @Test
    public void actDeadline_dateTimeFormat_formattedTimeDeadline() {
        Integer prevListSize = Data.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n"
            + "[D][X] watch powerRangers episode 3 (by: Feb 23 2022 09:00)\r\n"
            + "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "deadline watch powerRangers episode 3 /by 2022-02-23 09:00";
        assertAll("Deadline date time",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand),
                "Deadline format time inputs fails"),
            () -> assertTrue(TaskList.tasks.get(prevListSize).getDescription().equals("watch powerRangers episode 3"))
        );
        TaskList.tasks.remove(TaskList.tasks.get(prevListSize));
    }

    @Test
    public void actTodo_normalTodo_todoRespondMessage() {
        Integer prevListSize = Data.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n"
            + "[T][X] finish CS2113 Project!\r\n"
            + "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "todo finish CS2113 Project!";
        assertAll("Todo",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand), "Todo normal inputs fails"),
            () -> assertTrue(TaskList.tasks.get(prevListSize).getDescription().equals("finish CS2113 Project!"))
        );
        TaskList.tasks.remove(TaskList.tasks.get(prevListSize));
    }

    @Test
    public void actEvent_randomAtTime_customTimeDeadline() {
        Integer prevListSize = Data.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n"
            + "[E][X] watch Dora The Explorer episode 2 (at: your Free Time :))\r\n"
            + "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "event watch Dora The Explorer episode 2 -at your Free Time :)";
        assertAll("Event random time",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand),
                "Event custom time inputs fails"),
            () -> assertTrue(TaskList.tasks.get(prevListSize).getDescription()
                .equals("watch Dora The Explorer episode 2"))
        );
        TaskList.tasks.remove(TaskList.tasks.get(prevListSize));
    }

    @Test
    public void actEvent_dateTimeFormat_formattedTimeDeadline() {
        Integer prevListSize = TaskList.tasks.size();
        String updatedListSize = Integer.toString(prevListSize + 1);
        String expectedOutput = "Got it. I've added this task:\r\n"
            + "[E][X] watch Dora The Explorer episode 3 (at: Feb 23 2022 00:00)\r\n"
            + "Now you have " + updatedListSize + " tasks in the list.";
        String testCustomInputsCommand = "event watch Dora The Explorer episode 3 /at 2022-02-23";
        assertAll("Event custom time",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand),
                "Event format time inputs fails"),
            () -> assertTrue(TaskList.tasks.get(prevListSize).getDescription()
                .equals("watch Dora The Explorer episode 3"))
        );
        TaskList.tasks.remove(TaskList.tasks.get(prevListSize));
    }

    @Test
    public void actDone_indexInList_doneResponseMessage() {
        TaskList.tasks.add(new Deadline("watch Spongebob roundpants s3", "22-01-2001 12:00"));
        TaskList.tasks.add(new ToDo("eat banana while watching Minions s4"));
        TaskList.tasks.add(new Event("Tinder meetingg!!", "THE END OF TIME TT"));

        String expectedOutput = "Nice! I've marked this task as done:\r\n"
            + "[D][V] watch Spongebob roundpants s3 (by: Jan 22 2001 12:00)";
        String testCustomInputsCommand = "done 1";
        assertAll("Mark done",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand), "Mark done normal fails")
        );
        TaskList.tasks.removeAll(TaskList.tasks);
    }

    @Test
    public void actList_filledList_listResponseMessage() {
        TaskList.tasks.removeAll(TaskList.tasks);
        TaskList.tasks.add(new Deadline("watch Spongebob roundpants s3", "22-01-2001 12:00"));
        TaskList.tasks.add(new ToDo("eat banana while watching Minions s4"));
        TaskList.tasks.add(new Event("Tinder meetingg!!", "THE END OF TIME TT"));

        String expectedOutput = "Here is the list of tasks:\r\n"
            + "[D][X] watch Spongebob roundpants s3 (by: Jan 22 2001 12:00)\r\n"
            + "[T][X] eat banana while watching Minions s4\r\n"
            + "[E][X] Tinder meetingg!! (at: THE END OF TIME TT)\r\n";
        String testCustomInputsCommand = "list";
        assertAll("List normal tasks",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand), "List normal tasks fails")
        );
        TaskList.tasks.removeAll(TaskList.tasks);
    }

    @Test
    public void actUndone_indexInList_undoneResponseMessage() {
        TaskList.tasks.add(new Deadline("watch Spongebob roundpants s3", "22-01-2001 12:00"));
        TaskList.tasks.add(new ToDo("eat banana while watching Minions s4"));
        TaskList.tasks.add(new Event("Tinder meetingg!!", "THE END OF TIME TT"));

        TaskList.tasks.get(0).markAsDone(); //mark first item as done

        String expectedOutput = "Nice! I've marked this task as undone:\r\n"
            + "[D][X] watch Spongebob roundpants s3 (by: Jan 22 2001 12:00)";
        String testCustomInputsCommand = "undone 1";
        assertAll("Mark undone",
            () -> assertEquals(expectedOutput, duke.testSut(testCustomInputsCommand), "Mark undone normal fails")
        );
        TaskList.tasks.removeAll(TaskList.tasks);
    }
}
package data;

import constants.Constants;
import data.jobs.Task;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckerTest {
    static Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.TEST_FILENAME);
    static ArrayList<Task> taskList = new ArrayList<>();

    @Test
    public void checkClash_Weekly_() throws InterruptedException {
        d.testSut("clear", true, true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newDate = now.plus(Period.ofDays(7));
        String dayOfMonth = String.valueOf(newDate.getDayOfMonth());

        String userInput = "event eat sushi /at " + dtf.format(now) + "Weekly";
        d.testSut(userInput, false, true);
        assertTrue(d.testSut(userInput, false, true).contains(dayOfMonth));
    }

    private String[] testCommand = {"todo eat /by 12-12-2020 18:30",
        "deadline CS2113 Assignment /by 12-12-2020 18:30"};

    @Test
    public void checkClash_hasDuplicate_BooleanFalse() {
        d.testSut("clear", true, true);
        String expectedOutput = "Got it. I've added this task:\r\n"
                + "[D][X] CS2113 Assignment (by: Dec 12 2020 18:30)\r\n"
                + "Now you have 1 tasks in the list.";
        assertEquals(expectedOutput, d.testSut(testCommand[1], false, true));
        assertEquals(expectedOutput, d.testSut(testCommand[1], false, true));
    }

}

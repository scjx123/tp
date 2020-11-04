package command.action;

import constants.Constants;
import org.junit.jupiter.api.Test;
import seedu.duke.Domnus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatsTest {
    private String[] testCommand = {"stats", "stats -mod CS2113"};

    @Test
    public void statsAction_statsCommandsInputs_PercentageDisplayed() {
        Domnus d = new Domnus(false, System.out, System.in, Constants.PATH,
                Constants.TEST_TASK_FILENAME, Constants.TEST_COURSE_FILENAME);

        assertAll("StatsActionTest", () -> assertTrue(d.testSut(testCommand[0], false, true)
                        .contains("%")),
            () -> assertTrue(d.testSut(testCommand[1], false, true).contains("0.0%"))
        );
    }


}

package seedu.duke;

import command.Command;
import command.action.McAction;
import constants.Constants;
import data.SingleModule;
import data.TaskList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static constants.Constants.MC;
import static constants.Constants.MC_HEAD;
import static org.junit.jupiter.api.Assertions.*;

public class McActionTest {

    private String[] testCommand = {"mc","mc -p","mc -d","mc -p -d"};
    private McAction mc = new McAction();
    @Test
    @DisplayName("╯°□°）╯")
    public void McActionTest() {
        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
        //ArrayList<SingleModule> moduleList = new ArrayList<>(tasks.mods);

        assertAll("testCommand",
                () -> assertTrue(d.testSut(testCommand[0]).contains("721")),
                () -> assertTrue(d.testSut(testCommand[1]).contains("721")),
                () -> assertTrue(d.testSut(testCommand[2]).contains("12")),
                () -> assertTrue(d.testSut(testCommand[2]).contains("12"))

        );
    }
}

package seedu.duke;

import java.io.IOException;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws IOException, OtherException {
        Ui.showHelloMessage();
        Storage.readFile();
        Parser.handleCommand();
        Ui.showByeMessage();
    }

}

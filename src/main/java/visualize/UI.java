package visualize;

import command.action.ReminderAction;
import constants.Constants;
import data.SingleModule;
import data.Data;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Ui.
 */
public class UI {

    protected final Logger logger = Logger.getLogger(UI.class.getName());

    /**
     * The Stream.
     */
    protected PrintStream stream;
    /**
     * The Input.
     */
    protected InputStream input;

    /**
     * The Freshly switched.
     */
    protected boolean freshlySwitched;

    /**
     * The Input getter.
     */
    protected Scanner inputGetter;

    /**
     * Instantiates a new Ui.
     *
     * @param stream the stream
     * @param input  the input
     */
    public UI(PrintStream stream, InputStream input) {
        assert stream != null : "Null output stream";
        assert input != null : "Null input stream";
        logger.log(Level.INFO, "UI instantiated");
        this.stream = stream;
        this.input = input;
        inputGetter = new Scanner(input);
        freshlySwitched = false;
    }

    /**
     * Show welcome.
     */
    public void showWelcome() {
        stream.print(Constants.WELCOME);
    }

    /**
     * Show text.
     *
     * @param input the input
     */
    public void showText(String input) {
        stream.print(input);
    }

    /**
     * Update.
     *
     * @param input the input
     * @param tasks the tasks
     */
    public void update(String input, Data tasks) {
        showText(input);
    }

    /**
     * Next line string.
     *
     * @return the string
     */
    public String nextLine() {
        return inputGetter.nextLine();
    }


    /**
     * Sets switched.
     */
    public void setSwitched() {
        freshlySwitched = true;
    }

    /**
     * Shows Reminder.
     * @param data the data
     */
    public void showReminder(Data data) {
        showText(new ReminderAction().act(data));
    }
}

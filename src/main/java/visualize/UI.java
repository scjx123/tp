package visualize;

import constants.Constants;
import data.TaskList;
import java.util.Scanner;

/**
 * The type Ui.
 */
public class UI {

    /**
     * The Input getter.
     */
    protected Scanner inputGetter;

    /**
     * Instantiates a new Ui.
     */
    public UI() {
        inputGetter = new Scanner(System.in);
    }

    /**
     * Show welcome.
     */
    public void showWelcome() {
        System.out.print(Constants.WELCOME);
    }

    /**
     * Show text.
     *
     * @param input the input
     */
    public void showText(String input) {
        System.out.print(input);
    }

    /**
     * Update.
     *
     * @param input the input
     * @param tasks the tasks
     */
    public void update(String input, TaskList tasks) {
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

}

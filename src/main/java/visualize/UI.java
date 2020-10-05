package visualize;

import constants.Constants;
import data.SingleModule;
import data.TaskList;
import messages.MessageOptions;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The type Ui.
 */
public class UI {

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

    /**
     * Print module details.
     *
     * @param m the m
     */
    public void printModuleDetails(SingleModule m) {
        stream.println(m.moduleCode + m.moduleName + m.description + m.moduleMC + m.modulePrerequisite);
    }

    /**
     * Print module.
     *
     * @param m    the m
     * @param task the task
     */
    public void printModule(SingleModule m,String task) {
        switch (task) {
        case "code":
            stream.println("This is the module you are searching for: ");
            printModuleDetails(m);
            break;
        case "mc":
            stream.println("Here are all the 4mcs module in the list (:");
            printModuleDetails(m);
            break;
        case "description":
            stream.println("Is this what you are searching for? ");
            printModuleDetails(m);
            break;
        case "prereq":
            stream.println("These are the modules that are prerequisite(s) to the current module:\n");
            stream.println(m.modulePrerequisite);
            break;
        default:
            break;
        }
    }

    /**
     * Sets switched.
     */
    public void setSwitched() {
        freshlySwitched = true;
    }

    /**
     * Print mc title.
     *
     * @param i the
     */
    public void printMcTitle(int i) {
        stream.println("The total MC in this region is: " + i);
    }

}

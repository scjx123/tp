package visualize;

import constants.Constants;
import data.SingleModule;
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

    public void printModuleDetails(SingleModule m) {
        System.out.println(m.moduleCode + m.moduleName + m.description + m.moduleMC + m.modulePrerequisite);
    }

    public void printModule(SingleModule m,String task) {
        switch (task) {
        case "code":
            System.out.println("This is the module you are searching for: ");
            printModuleDetails(m);
            break;
        case "mc":
            System.out.println("Here are all the 4mcs module in the list (:");
            printModuleDetails(m);
            break;
        case "description":
            System.out.println("Is this what you are searching for? ");
            printModuleDetails(m);
            break;
        case "prereq":
            System.out.println("These are the modules that are prerequisite(s) to the current module:\n");
            System.out.println(m.modulePrerequisite);
            break;
        default:
            break;
        }
    }

    public void printMcTitle(int i) {
        System.out.println("The total MC in this region is: " + i);
    }

}

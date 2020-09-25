package visualize;

import constants.Constants;
import data.TaskList;
import java.util.Scanner;

public class UI {

    protected Scanner inputGetter;

    public UI() {
        inputGetter = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.print(Constants.WELCOME);
    }

    public void showText(String input) {
        System.out.print(input);
    }

    public void update(String input, TaskList tasks) {
        showText(input);
    }

    public String nextLine() {
        return inputGetter.nextLine();
    }

}

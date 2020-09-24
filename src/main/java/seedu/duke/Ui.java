package seedu.duke;

public class Ui {
    public static void showLine(){
        System.out.println("_____________________________________________________________________");
    }


    public static void showEmptyTodoMessage() {
        showLine();
        System.out.println("\n ☹ OOPS!!! The description of a todo cannot be empty.\n");
        showLine();
    }

    public static void getAddedTask() {
        showLine();
        System.out.println("   Got it. I've added this task:\n\t"
                + TaskList.tasks.get(TaskList.tasks.size()-1) + "\n   Now you have "
                + TaskList.tasks.size() + " tasks in the list.");
        showLine();
    }

    public static void showInvalidCommandMessage() {
        showLine();
        System.out.println("\n ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        showLine();
    }

    public static void showHelloMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }

    public static void showByeMessage() {
        showLine();
        String exit = "\nBye. Hope to see you again soon!\n";
        System.out.println("   " + exit);
        showLine();
    }
}


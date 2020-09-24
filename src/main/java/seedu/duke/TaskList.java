package seedu.duke;

import java.util.ArrayList;

public class TaskList {
    final static int MAX_LIST_SIZE = 100;
    protected static ArrayList<Task> tasks = new ArrayList<>(MAX_LIST_SIZE);

    public static void insertEvent(String userInput) {
        Event task = Parser.parseEvent(userInput);
        // assign task into actual task
        tasks.add(task);
    }

    public static void insertDeadline(String userInput) {
        Deadline task = Parser.parseDeadline(userInput);
        // assign task into actual task
        tasks.add(task);
    }

    public static void insertToDo(String userInput) throws ToDoException {
        ToDo task = Parser.parseToDo(userInput);
        // assign task into actual task
        tasks.add(task);
    }

    static void showNewlyAddedTask() {
        Ui.getAddedTask();
    }
}

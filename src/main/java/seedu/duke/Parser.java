package seedu.duke;

import java.util.Scanner;

public class Parser {
    public static Event parseEvent(String userInput) {
        int descriptionStartIndex = userInput.indexOf(" ");
        int descriptionEndIndex = userInput.indexOf("/at");
        String description = userInput.substring(descriptionStartIndex, descriptionEndIndex);
        String at = userInput.substring(descriptionEndIndex + 4);

        return new Event(description, at);
    }

    public static Deadline parseDeadline(String userInput) {
        int descriptionStartIndex = userInput.indexOf(" ");
        int descriptionEndIndex = userInput.indexOf("/by");
        String description = userInput.substring(descriptionStartIndex, descriptionEndIndex);
        String by = userInput.substring(descriptionEndIndex + 4);

        return new Deadline(description, by);
    }

    public static ToDo parseToDo(String userInput) throws ToDoException {
        int descriptionStartIndex = userInput.indexOf(" ");
        String description = userInput.substring(descriptionStartIndex);
        if (descriptionStartIndex == 4 && !description.isEmpty()) {
            return new ToDo(description);
        } else {
            throw new ToDoException();
        }
    }

    public static void insertToList(String userInput) throws OtherException{
        //first word of user's input
        String userInputFirstWord = userInput.split(" ")[0];
        //create task type based on user input
        switch (userInputFirstWord) {
        case "todo":
            try {
                TaskList.insertToDo(userInput);
            } catch (ToDoException e) {
                Ui.showEmptyTodoMessage();
            }
            break;
        case "deadline":
            TaskList.insertDeadline(userInput);
            break;
        case "event":
            TaskList.insertEvent(userInput);
            break;
        default:
            throw new OtherException();
        }
    }

    public static void handleCommand() {
        Scanner echo = new Scanner(System.in);
        // scan user input
        String userInput = echo.nextLine();

        // execute command of the user input until "bye" is entered
        while (!userInput.equals("Bye")){
                // insert into list
                try {
                    insertToList(userInput);
                    // print newly added task
                    TaskList.showNewlyAddedTask();
                } catch (OtherException e){
                    Ui.showInvalidCommandMessage();
                }

            // ask user input
            userInput = echo.nextLine();
        }
    }
}

package seedu.duke;


import java.io.IOException;
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

    public static void handleCommand() throws IOException {
        Scanner echo = new Scanner(System.in);
        // scan user input
        String userInput = echo.nextLine();

        // execute command of the user input until "bye" is entered
        while (!userInput.equals("Bye")){
            if(userInput.equals("list")){
                TaskList.getList();
            }
            else if(userInput.startsWith("done")){
                TaskList.setDone(userInput);
                // update the file
                Storage.createFile();
            }
            else if(userInput.startsWith("delete")){
                TaskList.delete(userInput);
                // update the file
                Storage.createFile();
            }
            else if(userInput.startsWith("find")) {
                find(userInput);
            }
            else if(userInput.startsWith("show")){
                TaskList.showList(userInput);
            }else {
                // insert into list
                try {
                    insertToList(userInput);
                    Storage.createFile();
                    // print newly added task
                    TaskList.showNewlyAddedTask();
                } catch (OtherException e) {
                    Ui.showInvalidCommandMessage();
                }
            }
            // ask user input
            userInput = echo.nextLine();
        }
    }
    /**
     * makes sense of existing todo task from saved file
     * @param userData
     * @return
     */
    public static ToDo parseExistingToDo(String userData) {
        // take out the description
        String description = userData.split("]")[2];

        // create To-Do task for passing over the user input to the actual task array
        return new ToDo(description);
    }

    /**
     * makes sense of existing deadline task from saved file
     * @param userData
     * @return
     */
    public static Deadline parseExistingDeadline(String userData) {
        // take indexes
        int descriptionStartIndex = userData.indexOf(" ");
        int descriptionEndIndex = userData.indexOf("by:");
        String description = userData.substring(descriptionStartIndex, descriptionEndIndex);
        // take the event time
        String by = userData.substring(descriptionEndIndex + 3);
        // create event task to be passed over to the actual task array
        return new Deadline(description, by);
    }

    /**
     * strips unused brackets from saved file
     * @param userData
     * @return
     */
    public static String stripBrackets(String userData) {
        // erase brackets
        userData = userData.replace("(", "");
        userData = userData.replace(")", "");
        return userData;
    }

    /**
     * makes sense of existing event task from saved file
     * @param userData
     * @return
     */
    public static Event parseExistingEvent(String userData) {
        // take indexes
        int descriptionStartIndex = userData.indexOf(" ");
        int descriptionEndIndex = userData.indexOf("at:");
        String description = userData.substring(descriptionStartIndex, descriptionEndIndex);
        // take the event time
        String at = userData.substring(descriptionEndIndex + 3);
        // create event task to be passed over to the actual task array
        return new Event(description, at);
    }

    /**
     * matches keyword in list and prints filtered list
     * @param userInput
     */
    public static void find(String userInput) {
        userInput = userInput.split(" ")[1];
        TaskList.filteredList(userInput);
    }

    /**
     * handles date format
     * @param dateAndTime
     * @return
     */
    public static String parseDate(String dateAndTime) {
        String[] dateComponent;
        String date;
        String time;
        String newDate;

        if (dateAndTime.contains(" ") && countSubstring(dateAndTime) == 2) {
            date = dateAndTime.split(" ")[0];
            time = dateAndTime.split(" ")[1];
            if (date.contains("/")) {
                dateComponent = date.split("/");
                newDate = dateComponent[2] + "-" + dateComponent[1] + "-" + dateComponent[0];
                if (time.contains(":")) {
                    return DateAndTime.convertDate(newDate) + ", " + DateAndTime.convertTime(time);
                }
                return DateAndTime.convertDate(newDate);
            }
        }
        return dateAndTime;
    }

    /**
     * counts string for date component
     * @param dateAndTime
     * @return
     */
    public static int countSubstring(String dateAndTime){
        String[] substring = dateAndTime.split(" ");
        int count = 0;
        for(int i=0; i < substring.length; i++){
            count++;
        }
        return count;
    }
}

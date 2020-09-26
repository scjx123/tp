package seedu.duke;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class TaskList {
    final static int MAX_LIST_SIZE = 100;
    protected static ArrayList<Task> tasks = new ArrayList<>(MAX_LIST_SIZE);
    protected static Storage storage;

    public TaskList(Storage storage){
        this.storage = storage;
    }

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
    public static void printAddedTask() {
        Ui.getAddedTask();
    }

    /**
     * shows the task list
     */
    public static void getList(){
        Ui.getListHeader();
        for(int i = 0; i < tasks.size(); i++){
            System.out.println("   " + (i + 1) + ". " + tasks.get(i));
        }
        Ui.lineSeparator();
    }

    /**
     * mark the selected task as done
     * @param userInput
     */
    public static void setDone(String userInput) {
        try{
            // take out the word after "done"
            String indexString = userInput.split(" ")[1];
            // change the word into integer
            Integer indexTask = Integer.parseInt(indexString);
            // mark task as done
            tasks.get(indexTask-1).markAsDone();
        }catch (IndexOutOfBoundsException e) {
            Ui.getItemNotInListMessage();
        } catch (NumberFormatException e) {
            Ui.getInvalidNumberMessage();
        }

    }

    /**
     * delete selected task
     * @param userInput
     */
    public static void delete(String userInput){
        try{
            // take out the word after "delete"
            String indexString = userInput.split(" ")[1];
            // change the word into integer
            Integer indexTask = Integer.parseInt(indexString);
            // view delete message first
            tasks.get(indexTask-1).deleteTaskMessage();
            // erase the selected task from the array
            tasks.remove(indexTask-1);
        }catch (IndexOutOfBoundsException e) {
            Ui.getItemNotInListMessage();
        } catch (NumberFormatException e) {
            Ui.getInvalidNumberMessage();
        }

    }

    /**
     * makes new filtered list using the passed keyword
     * @param tasksData
     * @param filterString
     * @return
     */
    public static ArrayList<Task> filterByString(ArrayList<Task> tasksData, String filterString) {
        ArrayList<Task> filteredTaskList = (ArrayList<Task>) tasksData.stream()
                .filter((s) -> s.getDescription().contains(filterString))
                .collect(toList());
        return filteredTaskList;
    }

    /**
     * prints the filtered list
     * @param userInput
     */
    public static void filteredList(String userInput){
        Ui.showFilteredListHeader();
        ArrayList<Task> filteredTasks = filterByString(tasks, userInput);
        for(int i=0; i < filteredTasks.size(); i++){
            System.out.println("    " +  (i+1) + ". " + filteredTasks.get(i));
        }
        Ui.lineSeparator();
    }

    public static void showList(String userInput) {
        String indexString = userInput.split(" -")[1];
        String flag = "";
        int count = 1;

        Ui.getListHeader();
        if(indexString.equals("deadline")){
            flag = "D";
        }else if(indexString.equals("event")){
            flag = "E";
        }else{
            flag = "";
        }

        /*
        ArrayList<String> datestring=new ArrayList<String>();
        datestring.add("01/21/2013 @03:13 PM");
        datestring.add("01/21/2013 @04:37 PM");
        datestring.add("01/21/2013 @10:41 AM");
        datestring.add("01/21/2013 @10:48 AM");
        datestring.add("01/22/2013 @06:16 AM");
        datestring.add("01/22/2013 @06:19 AM");
        datestring.add("01/21/2013 @05:19 PM");
        datestring.add("01/21/2013 @05:19 PM");


        for (String s : datestring){
            System.out.println(s);
        }
        */

        ArrayList<Task> sortTask =  new ArrayList<>(MAX_LIST_SIZE);
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getTaskType().equals(flag)){
                sortTask.add(tasks.get(i));

            }

        }
        sortDates(sortTask);
        for (int i = 0; i<sortTask.size(); i++){
            System.out.println("   " + (i + 1) + ". " + sortTask.get(i));
        }
        Ui.lineSeparator();

        System.out.println(indexString);

    }

    public static ArrayList<Task> sortDates(ArrayList<Task> datestring){
        Collections.sort(datestring, new Comparator<Task>() {
            DateFormat f = new SimpleDateFormat("MM/dd/yyyy '@'hh:mm a");
            @Override
            public int compare(Task o1, Task o2) {
                try {
                    return f.parse(o1.getTime()).compareTo(f.parse(o2.getTime()));
                } catch (ParseException e) {
                    Ui.getInvalidDateFormat();
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return datestring;
    }

    public static void showNewlyAddedTask() {
        Ui.getAddedTask();
    }
}

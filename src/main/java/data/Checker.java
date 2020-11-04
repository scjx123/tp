package data;

import data.jobs.Task;
import data.jobs.ToDo;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

public class Checker {
    /**
     * Status of clashing item.
     */
    public boolean isClash = false;

    /**
     * Status of clashing item.
     */
    public boolean isTodo = false;

    /**
     * used for checking of type of list being passed in.
     */
    public String listType = "tasks";
    /**
     * Default period of recurrence is 7 days.
     */
    Period recurrence = Period.ofDays(7);
    /**
     * To be instantiated with item to be checked.
     */
    private Item item;
    /**
     * to be instantiated with list to be checked.
     */
    private ArrayList<Item> list;

    /**
     * Constructor for Checker, initializing item and list variable.
     *
     * @param list The list of Item
     * @param item The item to be checked
     */
    public Checker(ArrayList<Item> list, Item item) {
        this.list = list;
        this.item = item;
    }

    /**
     * Affirm that item is not an instance of 'todo' follow by, calling checkClash to check duplicate
     * it then return isClash.
     *
     * @return isClash boolean variable
     */
    public boolean checkDuplicates() {
        if (item instanceof ToDo) {
            isTodo = true;
        }

        checkClash(list, item);
        return isClash;
    }


    /**
     * Checks for duplicated when given a list and the item to be checked.
     *
     * @param list the list of items
     * @param item the item to be checked
     */
    public void checkClash(ArrayList<Item> list, Item item) {
        for (Item t : list) {
            LocalDateTime firstDateTime = item.getDateTime();
            LocalDateTime secondDateTime = t.getDateTime();
            String firstDescription = item.getName();
            String secondDescription = t.getName();

            if(isTodo) {
                if(firstDescription.equals(secondDescription)) {
                    isClash = true;
                }
            }else if (firstDescription.equals(secondDescription) &&
                    firstDateTime.isEqual(secondDateTime)){
                isClash = true;
            }
        }
    }

    /**
     * Check if today is the day for the tasks if yes, it will 'update' the
     * assignment with a new deadline.
     *
     * @return true if today is the date of the assignment.
     */
    public LocalDateTime checkRecurrenceDate(Task task) {
        LocalDateTime newDate = null;
        if (task.isWeekly) {
            //assuming 7 days recurrence
            LocalDateTime todayDate = LocalDateTime.now();
            LocalDateTime endDate = task.getDateTime();
            if (todayDate.isAfter(endDate)) {
                newDate = endDate.plus(recurrence);
                assert newDate != null;
                assert newDate.isAfter(endDate) : "Updated date should be later than previous date";
            }
        }
        return newDate;
    }

}

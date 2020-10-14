package data;

import data.jobs.Task;
import data.jobs.ToDo;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

public class Checker {
    public boolean isClash = false;
    public String listType = "tasks";
    Period recurrence = Period.ofDays(7);
    private Item item;
    private ArrayList<Item> list;

    public Checker(ArrayList<Item> list, Item item) {
        this.list = list;
        this.item = item;
    }

    public boolean checkDuplicates() {
        if (item instanceof ToDo) {
            return false;
        } else {
            checkClash(list, item);
            return isClash;
        }
    }

    public void checkClash(ArrayList<Item> list, Item item) {
        switch (listType) {
        case "tasks":
            for (Item t : list) {
                LocalDateTime firstDateTime = item.getDateTime();
                LocalDateTime secondDateTime = t.getDateTime();
                String firstDescription = item.getName();
                String secondDescription = t.getName();
                if (firstDescription.equals(secondDescription)
                        && firstDateTime.isEqual(secondDateTime)) {
                    isClash = true;
                    break;
                }
            }
            break;
        case "mods":
        default:
            break;
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
                assert newDate.isAfter(endDate) : "Updated date should be later than previous date";
            }
        }
        return newDate;
    }

}

package data;

import data.jobs.Deadline;
import data.jobs.Event;
import jdk.jfr.Description;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Checker {
    private Item item;
    public boolean isClash = false;
    public String listType = "tasks";
    private ArrayList<Item> list;

    public Checker(ArrayList<Item> list, Item item){
        if(item instanceof Deadline || item instanceof Event){
            this.list = list;
            this.item = item;
            check();
        }
    }

    public void check() {
        checkDateClash(list,item);
    }

    public void checkDateClash(ArrayList<Item> list, Item item){
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


}

package data;

import data.jobs.Deadline;
import data.jobs.Event;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClashChecker {
    private Item item;
    public boolean isClash = false;
    public String listType = "tasks";
    private ArrayList<Item> list;

    public ClashChecker(ArrayList<Item> list, Item item){
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
                LocalDateTime first = item.getDateTime();
                LocalDateTime second = t.getDateTime();
                if (first != null && second != null && first.isEqual(second)) {
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

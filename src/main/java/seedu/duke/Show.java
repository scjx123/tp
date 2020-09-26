package seedu.duke;

import java.util.ArrayList;
//show upcoming deadlines and upcoming events
public class Show {
    private ArrayList<Task> inventory;
    public Show(ArrayList<Task> inventory){
        this.inventory = inventory;
    }
    /**
     * Prints out all the items in the inventory
     *
     */
    public void listInventory(){
        for(int i = 0; i < inventory.size(); i++){
            System.out.print(i+1 +".");
            System.out.println(inventory.get(i));
        }
        System.out.println();
    }
}

package data;

/**
 * The type Item.
 */
public class Item {

    /**
     * The Description.
     */
    public String description;

    /**
     * Instantiates a new Item.
     *
     * @param description the description
     */
    public Item(String description) {
        this.description = description;
    }

    /**
     * Gets name.
     *
     * @return the name
     */

    //For SingleModule item it will return module code
    //For Task item, it will return task description
    public String getName() {
        return description;
    }


}

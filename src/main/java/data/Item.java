package data;

public class Item {

    public String description;

    public Item(String description) {
        this.description = description;
    }


    //For SingleModule item it will return module code
    //For Task item, it will return task description
    public String getName() {
        return description;
    }


}

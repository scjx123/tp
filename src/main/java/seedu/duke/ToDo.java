package seedu.duke;

public class ToDo extends Task{
    public ToDo(String description) {
        super(description, "T", null);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString() ;
    }

}

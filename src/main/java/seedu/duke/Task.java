package seedu.duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected String date;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTime() {
        return date;
    }

    public void setTime(String time) {
        this.date = time;
    }

    public Task(String description, String taskType, String date) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        this.date = date;
    }

    public String getStatusIcon() {
        return (isDone ? "O" : "X"); //return tick or X symbols
    }

    public String getDescription(){
        return description;
    }

    public void markAsDone(){
        // set isDone to be true
        isDone = true;
        // print the marked task
        System.out.printf("    \n" +
                "   Nice! I've marked this task as done:\n" +
                "\t" + toString() +"\n");
    }

    public void deleteTaskMessage(){
        System.out.println("     Noted. I've removed this task: \n" +
                "     " + toString() + "\n");
    }
    public void setDone() {
        this.isDone = true;
    }
    @Override
    public String toString() {
        return "["+ getStatusIcon() + "]" + getDescription();
    }
}

package main.java.model;

public abstract class Task {
    public String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public void unmark(){
        this.isDone = false;
    }
    public String getStatus(){
        return (isDone ? "[x]" : "[]");
    }
    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description;
    }
}

package model;

public abstract class Task {
    public String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }

    public String getStatus() {
        return (isDone ? "[X]" : "[ ]");
    }

    public String getFIleStatus() {
        return (isDone ? "1" : "0");
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description;
    }

    public String fileFormat() {
        return getType() + " | " + getFIleStatus() + " | " + description;
    }
}

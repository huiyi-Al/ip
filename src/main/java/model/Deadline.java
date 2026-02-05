package model;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " +
                description + " (by: " + getDeadline() + ")";
    }

    @Override
    public String getType() {
        return "D";
    }
}

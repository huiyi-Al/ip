package model;

/**
 * Represents a Deadline Task
 * Contains a date as deadline
 */
public class Deadline extends Task {
    private String deadline;

    /**
     * Constructs a Deadline Task
     *
     * @param description  A short description or name of the task
     * @param deadline     The date of task deadline
     */
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

    @Override
    public String fileFormat() {
        return getType() + " | " + getFIleStatus() + " | " + description + " | " + getDeadline();
    }
}

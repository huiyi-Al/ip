package main.java.model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/**
 * Represents a Deadline Task
 * Contains a date as deadline
 */
public class Deadline extends Task {
    private LocalDate deadline;

    /**
     * Constructs a Deadline Task
     *
     * @param description  A short description of the task
     * @param deadline     The date of task deadline
     */
    public Deadline(String description, LocalDate deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Returns the type of task
     *
     * @return type represent as string "D"
     */
    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String toString() {
        String formattedDate = deadline.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "[" + getType() + "]" + getStatus() + " " + description + " (by: " + formattedDate + ")";
    }
}
package main.java.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private LocalDate deadline;

    public Deadline(String description, LocalDate deadline){
        super(description);
        this.deadline = deadline;
    }
    @Override
    public String getType() {
        return "D";
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        String formattedDate = deadline.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "[" + getType() + "]" + getStatus() + " " + description + " (by: " + formattedDate + ")";
    }
}
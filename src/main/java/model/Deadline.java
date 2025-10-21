package main.java.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private String deadline;

    public Deadline(String description, String deadline){
        super(description);
        this.deadline = deadline;
    }
    @Override
    public String getType() {
        return "D";
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description + " (by:" + deadline + ")";
    }
}
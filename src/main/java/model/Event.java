package main.java.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private String start;
    private String end;

    public Event(String description, String start, String end){
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String getType() {
        return "E";
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description + " (from: " + start + " to:" + end + ")";
    }
}

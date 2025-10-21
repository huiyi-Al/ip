package main.java.model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String description, LocalDateTime start, LocalDateTime end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String getType() {
        return "E";
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        String formattedStart = start.format(DateTimeFormatter.ofPattern("MMM gg yyyy, HH:mm"));
        String formattedEnd = end.format(DateTimeFormatter.ofPattern("MMM gg yyyy"));
        return "[" + getType() + "]" + getStatus() + " " + description + " (from: " + formattedStart + " to: " + formattedEnd + ")";
    }
}

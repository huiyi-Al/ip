package main.java.model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a Event Task
 * Each task contains both starting time and ending time
 */
public class Event extends Task{
    private LocalDateTime start;
    private LocalDateTime end;

    /**
     * Constructs a Event task
     *
     * @param description   A short description of the task
     * @param start         The time task start
     * @param end           The time task end
     */
    public Event(String description, LocalDateTime start, LocalDateTime end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the type of event task
     *
     * @return type represent as string "E"
     */
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Returns starting time of task
     *
     * @return the starting time
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Returns ending time of task
     *
     * @return the ending time
     */
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

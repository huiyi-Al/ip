package model;

/**
 * Represents an Event Task
 * Contains a starting date and an ending date
 */
public class Event extends Task{
    private String startTime;
    private String endTime;

    /**
     * Constructs an Event Task
     *
     * @param description  A short description or name of the task
     * @param startTime    The date for task start
     * @param endTime      The date for task end
     */
    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " +
                description + "(from: " + getStartTime() + " to:" + getEndTime() + ")";
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String fileFormat() {
        return getType() + " | " + getFIleStatus() + " | " + description + " | " + getStartTime() + " | " + getEndTime();
    }
}

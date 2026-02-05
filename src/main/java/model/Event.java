package model;

public class Event extends Task{
    private String startTime;
    private String endTime;

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
}

package main.java.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeService {
    private LocalDate date = LocalDate.now();
    private static final DateTimeFormatter INPUT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy[ HHmm]");
    private static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private static final DateTimeFormatter OUTPUT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("MMM DD YYYY, hh:mm:ss");

    public LocalDate parseDate(String date) {
        return LocalDate.parse(date, INPUT_DATETIME_FORMATTER);
    }

    public String formatDate(LocalDate date) {
        return date.format(OUTPUT_DATE_FORMATTER);
    }

    public LocalDateTime parseDateTime(String datetime) {
        return LocalDateTime.parse(datetime, INPUT_DATETIME_FORMATTER);
    }

    public String formatDateTime(LocalDateTime datetime) {
        return datetime.format(OUTPUT_DATETIME_FORMATTER);
    }

}

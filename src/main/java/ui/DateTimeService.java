package main.java.ui;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Support reading some specific string as date and time
 */
public class DateTimeService {
    private LocalDate date = LocalDate.now();
    private static final DateTimeFormatter INPUT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy[ HHmm]");
    private static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private static final DateTimeFormatter OUTPUT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("MMM DD YYYY, hh:mm:ss");

    /**
     * Read string as date in a format
     *
     * @param date  A date user input as string
     * @return Localdate in a format
     */
    public LocalDate parseDate(String date) {
        return LocalDate.parse(date, INPUT_DATETIME_FORMATTER);
    }

    /**
     * Returns date in string
     *
     * @param date  A date in a specific format
     * @return date in string
     */
    public String formatDate(LocalDate date) {
        return date.format(OUTPUT_DATE_FORMATTER);
    }

    /**
     * Read string as date and time in a format
     *
     * @param datetime  A date with time  user input as string
     * @return String representing date and time
     */
    public LocalDateTime parseDateTime(String datetime) {
        return LocalDateTime.parse(datetime, INPUT_DATETIME_FORMATTER);
    }

    /**
     * Returns date and time  in string
     *
     * @param datetime  Date and time in a specific format
     * @return date and time in string
     */
    public String formatDateTime(LocalDateTime datetime) {
        return datetime.format(OUTPUT_DATETIME_FORMATTER);
    }

}

package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

public class DateTimeService {

    private static final List<DateTimeFormatter> SUPPORTED_FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("d/MM/yyyy"),

            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"),
            DateTimeFormatter.ofPattern("d/MM/yyyy HHmm")
    );

    private static final DateTimeFormatter OUTPUT_DATE = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private static final DateTimeFormatter OUTPUT_DATETIME = DateTimeFormatter.ofPattern("hh:mm, MMM dd, yyyy");

    public static String outputDateTime(String input) {

        for (DateTimeFormatter formatter : SUPPORTED_FORMATTERS) {

            try {
                boolean hasTime = formatter.toString().contains("HHmm");

                if (hasTime) {
                    LocalDateTime localDateTime = LocalDateTime.parse(input, formatter);
                    return localDateTime.format(OUTPUT_DATETIME);
                } else {
                    LocalDate localDate = LocalDate.parse(input, formatter);
                    return localDate.format(OUTPUT_DATE);
                }
            } catch (DateTimeParseException e) {
                continue;
            }
        }
        return input;
    }
}

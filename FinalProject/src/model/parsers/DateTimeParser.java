package model.parsers;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Parse format yy-mm-dd hh:mm:ss
 * using model.parsers.TimeParser inside
 */
public class DateTimeParser {
    public static DateTime parse(String string) {
        String date = string.split(" ")[0];
        String time = string.split(" ")[1];
        String[] elements = date.split("-");
        int year = Integer.parseInt(elements[0].trim());
        int month = Integer.parseInt(elements[1].trim());
        int day = Integer.parseInt(elements[2].trim());

        DateTime dateTime = new DateTime(year, month, day, 0, 0);
        Duration duration = TimeParser.parseTimeToDuration(time);
        dateTime = dateTime.plus(duration);
        return dateTime;
    }
}

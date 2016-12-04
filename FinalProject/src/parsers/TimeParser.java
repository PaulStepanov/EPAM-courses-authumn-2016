package parsers;

import org.joda.time.Duration;
/**
 * Parse time in format hh:mm:ss.ms to Duration object from JodaTime*/
public class TimeParser {
    public static Duration parseTimeToDuration(String time) {
        String[] elements = time.split(":");
        int hours = Integer.parseInt(elements[0]);
        int minutes = Integer.parseInt(elements[1]);
        int seconds = (int)(Double.parseDouble(elements[2]));
        long milliseconds = hours * 3600000 + minutes * 60000 + seconds * 1000;
        return new Duration(milliseconds);
    }
}

package parsers;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Created by Павел on 28-Nov-16.
 */
public class TimeParser {
    public static Duration parseTimeToDuration(String time) {
        String[] elements = time.split(":");
        int hours = Integer.parseInt(elements[0]);
        int minutes = Integer.parseInt(elements[1]);
        int seconds = Integer.parseInt(elements[2]);
        long milliseconds = hours * 3600000 + minutes * 60000 + seconds * 1000;
        return new Duration(milliseconds);
    }
}

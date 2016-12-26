package model.parsers;

import org.joda.time.Duration;
import org.joda.time.Period;

/**
 * Parse duration to hh:mm:ss
 */
public class DurationParser {
    public static String parseDuration(Duration duration) {
        StringBuilder result = new StringBuilder();
        Period period = duration.toPeriod();
        result.append(period.getHours());
        result.append(":");
        result.append(period.getMinutes());
        result.append(":");
        result.append(period.getSeconds());
        return result.toString();
    }

}

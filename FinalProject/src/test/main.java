package test;

import parsers.TimeParser;

/**
 * Created by Павел on 28-Nov-16.
 */
public class main {
    public static void main(String... args) {
        System.out.println(TimeParser.parseTimeToDuration("6:03:8").getStandardHours());
    }
}

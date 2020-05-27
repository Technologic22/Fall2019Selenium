package com.automation.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {
    /**
     * This method returns current date as a String
     * Provide a format as a pattern
     * MM- to specify a month like: 01, 02, 03
     * MMM- to specify month as: Jan Feb Mar
     *
     * dd- to specify day, s.a. 01,02,03
     *
     * yyyy- to specify year as: 2010, 2020
     *
     * @param format i.e. MMM dd, yyyy
     * @return current date as a string
     *
     * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
     */
    public static String getCurrentDate(String format){
        return LocalDate.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    /**
     * This method returns difference between end and start time
     * @param start time
     * @param end end
     * @param format i.e. h:mm a (12:00 PM, 00:00 AM)
     * @return difference between end time and start time as a long
     */

    public static long  getTimeDifference (String start, String end, String format){
        LocalTime startTime= LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime= LocalTime.parse(end, DateTimeFormatter.ofPattern(format));

        return ChronoUnit.HOURS.between(startTime,endTime);
    }
}

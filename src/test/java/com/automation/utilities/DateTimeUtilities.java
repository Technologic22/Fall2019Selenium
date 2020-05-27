package com.automation.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
}

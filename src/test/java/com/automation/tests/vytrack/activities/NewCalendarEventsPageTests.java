package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalendarEventsPageTests extends AbstractTestBase {

    /**
 * Test Case: Default options
 * Login as sales manager
 * Go to Activities --> Calendar Events
 * Click on Create Calendar Event
 * Default owner name should be current
 * */

    @Test
    public void defaultOptionsTest(){
        LoginPage loginPage= new LoginPage();
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentuserName());

        String expectedDate= DateTimeUtilities.getCurrentDate("MMM dd, yyyy");
        String actualDate= calendarEventsPage.getStartDate();
        Assert.assertEquals(expectedDate, actualDate);
    }

    /**
     * 15 minutes until 3:45
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/
    @Test
    public void timeDifference(){
        LoginPage loginPage= new LoginPage();
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.clickToCreateCalendarEvent();
        String startTime= calendarEventsPage.g
    }
}

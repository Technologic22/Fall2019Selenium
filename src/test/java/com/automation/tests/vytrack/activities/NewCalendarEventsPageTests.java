package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsPageTests extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/
    @Test
    public void defaultOptionsTest(){

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
       loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        String startTime= calendarEventsPage.getStartTime();
        String endTime= calendarEventsPage.getEndTime();
        String format= "h:mm a";  //format such as: 5:20 AM
        long actual= DateTimeUtilities.getTimeDifference(startTime, endTime,format);

        Assert.assertEquals(actual, 1, "Time difference is not correct");
    }

    @Test
    public void verifyColumnNamesTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        List<String>expected= Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
    }

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description){
       //when U ve more than 1 test, 1st one pass, others fail
        //U get 'SESSION ID NULL' exception, 'Cuz driver was not initialized on time
        //to solve: just initialize pageobject inside a test

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //only for extent report. To create a test in html report
           test=report.createTest("Create calendar event for "+title);
    loginPage.login();
    calendarEventsPage.navigateTo("Activities", "Calendar Events");
    calendarEventsPage.clickToCreateCalendarEvent();
    calendarEventsPage.enterCalendarEventTitle(title);
    calendarEventsPage.enterCalendarEventDescription(description);
    calendarEventsPage.clickOnSaveAndClose();

    //verify that calendar event info is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);

            //for extent report, specify that test passed in report (if all assertions passed!)
        test.pass("Calendar event created successfully!");
    }

    @DataProvider
    public Object[][] calendarEvents(){
        return new Object[][]{
                {"Daily Stand-Up", "Scrum meeting to provide updates!"},
                {"Sprint Review", "Team discussing previous sprint!"},
                {"Sprint Planning", "Discussing backlog for following sprint"}
        };
    }
}

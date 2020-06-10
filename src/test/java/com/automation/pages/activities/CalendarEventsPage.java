package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "a[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy (className = "select2-chosen")
    private WebElement owner;

    @FindBy (css = "[id^=date_selector_oro_calendar_event_form_start]")
    private WebElement startDate;

    @FindBy (css = "[id^=time_selector_oro_calendar_event_form_start]")
    private WebElement startTime;

    @FindBy(css = "[id^=time_selector_oro_calendar_event_form_end]")
    private WebElement endTime;

    @FindBy (className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "[id^=\"oro_calendar_event_form_title\"]")
    private WebElement title;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description']")
    private WebElement descriptionFrame;

    @FindBy(id="tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] >button")
    private WebElement saveAndClose;

    @FindBy (xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']//following-sibling::div//p[1]")
    private WebElement generalInfoDescription;



    public List<String>getColumnNames(){
        BrowserUtils.waitForPageToLoad(10);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }

    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        //wait for element to be present in the  DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(10);
    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^=time_selector_oro_calendar_event_form_start]")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }
}

package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

        WebElement simpleDropdown = driver.findElement(By.id("dropdown")); //create webelement for Select method / dropdown
        Select  selectSimpleDropDown = new Select(simpleDropdown);  // pass webelement into Select ocnstructor
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropDown.selectByVisibleText("Option 1");
        BrowserUtils.wait(4);

        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1985");
        BrowserUtils.wait(1);
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByVisibleText("July");
        BrowserUtils.wait(1);
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("22");
        BrowserUtils.wait(2);

        //Select all motnhs one by one

        List <WebElement> months = selectMonth.getOptions();

        for (WebElement eachMonth : months) {

            String month= eachMonth.getText();
            selectMonth.selectByVisibleText(month);

        }
                BrowserUtils.wait(3);

        for (int i = 0; i < 12; i++) {
            selectMonth.selectByIndex(i);
            BrowserUtils.wait(1);
        }

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("New York"); //currently selected option
        BrowserUtils.wait(2);
            //to verify if we have selected correctly
            //selectState.getFirstSelectedOption(): ==>> returns a web element
        // .getText();  ==>> thats why we need to use the getText method to get and print text Visible text

        String selected = selectState.getFirstSelectedOption().getText();  // Option that is currently selected
        System.out.println(selected);

        if (selected.equalsIgnoreCase("New York")){
            System.out.println("Test PASS");
        } else{
            System.out.println("Test FAIL");
        }
        System.out.println("<<============================>>");
        List <WebElement> states = selectState.getOptions();

        for (WebElement state : states ) {
            String stateName = state.getText();
            System.out.println(stateName);
            selectState.selectByVisibleText(stateName);
        }









        BrowserUtils.wait(2);
        //driver.close();
    }
}

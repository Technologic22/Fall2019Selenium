package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

        Select states = new Select(driver.findElement(By.id("state")));
        states.selectByValue("NY");

        String expected = "New York";
        String actual = states.getFirstSelectedOption().getText();  //returns your first selected optoin
        System.out.println("Expected: " + expected);
        System.out.println("Actual: "+actual);
        System.out.println();
        if (expected.equals(actual)){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test Fail");
        }


        BrowserUtils.wait(4);
        driver.close();
    }
}

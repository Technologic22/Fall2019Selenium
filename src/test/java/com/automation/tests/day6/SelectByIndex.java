package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
                WebDriver driver = DriverFactory.createDriver("chrome");
                driver.get("http://practice.cybertekschool.com/dropdown");
                BrowserUtils.wait(3);
                driver.manage().window().maximize();

        Select states = new Select(driver.findElement(By.id("state")));
        states.selectByIndex(9);   //option name also counted as an index

        //how to select last option
        states.selectByIndex(states.getOptions().size()-1);



        BrowserUtils.wait(3);
        driver.quit();
    }
}

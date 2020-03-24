package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.Utilities;

public class RadioButtonsTest {
    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        BrowserUtils.wait(4);

        if (blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("Clicked on Black Button");
            blackButton.click();
        }else {
            System.out.println("Not Clicked on Black Button");
        }

        BrowserUtils.wait(3);
        //how to verify if black button is clicked
        if (blackButton.isSelected()){
            System.out.println("Test PASS");
        }else {
            System.out.println("Fail");
        }

        BrowserUtils.wait(3);


        driver.quit();
    }
}

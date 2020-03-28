package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(2);
        String popUpText = driver.switchTo().alert().getText();
        System.out.println(popUpText);
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);

        String expected = "You successfuly clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)){
            System.out.println("Test Pass");
        }else {
            System.out.println("Test Fail");
            System.out.println("actual = " + actual);
            System.out.println("expected = " + expected);
        }

        System.out.println();

        buttons.get(1).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss(); /// to reject warning
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if (expected2.equals(actual2)){
            System.out.println("Test2 Pass");
        }else{
            System.out.println("Test2 Fail");
        }


        buttons.get(2).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Today is 23rd March");
        BrowserUtils.wait(3);
        alert.accept();

        String expected3 = "You entered: Today is 23rd March";  //!!! Be Careful with You Enetered: part because its added by HTML
        String actual3 = driver.findElement(By.id("result")).getText();
        if (actual3.endsWith("March")){
            System.out.println("Test3 Pass");
        }else{
            System.out.println("Test3 Fail");
        }




        BrowserUtils.wait(3);
       // driver.quit();
    }
}

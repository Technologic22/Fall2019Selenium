package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame {
    public static void main(String[] args) throws Exception{
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(4);

        driver.switchTo().frame("frame-top");
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-middle");

        WebElement bodyContent = driver.findElement(By.id("content"));  // comntent inside the child frame
        BrowserUtils.wait(2);
        System.out.println(bodyContent.getText());

       // driver.switchTo().defaultContent()  // goes back to main HTMLK
        driver.switchTo().parentFrame();  // to go to top frame
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-right");

        WebElement bodyText = driver.findElement(By.tagName("body"));
        System.out.println(bodyText.getText());
        //to switch to the bottom frame we need to go to default frame
        //because it is not a child frame, it is sibling frame!!!
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-bottom");

        WebElement bottomText = driver.findElement(By.tagName("body"));
        System.out.println(bottomText.getText());




        BrowserUtils.wait(3);
        driver.quit();
    }
}

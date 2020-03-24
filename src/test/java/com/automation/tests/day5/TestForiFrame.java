package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForiFrame {
    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);

        //!! Before looking for the element inside iframe we need to jump to the iFrame!
        //so we have this below method

        driver.switchTo().frame("mce_0_ifr");
        //now that iframe content is visible to SE
        //once we pass: specify name, id, webelement of iframe.
        //like jumping to another layer
        WebElement textInput = driver.findElement(By.id("tinymce"));

        String text = textInput.getText();
        System.out.println(text);

        textInput.clear();
        textInput.sendKeys("No more adds welcome!");
        BrowserUtils.wait(3);

        driver.switchTo().defaultContent();   // get back to main doc - exit from frame!!
        BrowserUtils.wait(3);

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        BrowserUtils.wait(3);
        driver.quit();
    }
}

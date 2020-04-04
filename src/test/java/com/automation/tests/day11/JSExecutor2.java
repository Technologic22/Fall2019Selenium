package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {
    private WebDriver driver;


    @Test
    public void getTitle(){
        String actual=driver.getTitle();
        String expected="Practice";
        //assertEquals(actual, expected);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //we create javascriptexecutor object by casting webdriver object
        String pageTitle = (String) js.executeScript("return document.title");
        String pageTitle2= js.executeScript("return document.title").toString();
        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return document.title - javascript code
        //document - represents HTML page
        //.toString() - to avoid additional casting from Object to String

        assertEquals(pageTitle,expected);
    }

    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        System.out.println("link = " + link);
        //link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", link);
        //after "", Webelement can be added as "var args" - so U can list any number
        // as part of JS code,
        //arguments listed after (,-comma!) use index to get specific webelement
        //Webelement arguments = {element, link, link2, link3}


    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }
}

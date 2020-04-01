package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestPractice {

    private WebDriver driver;

    @Test (description = "go to form authentication page")  //@Test annotation makes methods executed as tests
    public void loginTest(){
        driver.findElement(By.partialLinkText("Form Authentication")).click();
        BrowserUtils.wait(4);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(3);
        driver.findElement(By.id("wooden_spoon")).click();
        String actual=driver.findElement(By.className("subheader")).getText();
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        System.out.println("loginMessage = " + actual);
        BrowserUtils.wait(3);
        //if assertion fails, it will throw exception and message will be printed
        //3 parameters: actual, expected and message in case of results  don't match
       Assert.assertEquals(actual, expected, "Sub-header message is not matching!");

    }

    @Test
    public void verifyPassword(){
        driver.findElement(By.partialLinkText("Forgot Password")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("email")).sendKeys("biomuhammet@mail.ru", Keys.ENTER);
        BrowserUtils.wait(3);
        String actual = driver.findElement(By.tagName("h4")).getText();
        System.out.println("actual = " + actual);
        String expected="Your e-mail's been sent!";

        Assert.assertEquals(actual,expected, "something went wrong!");
    }
        /*
        * Task: given user is on the practice landing page
        * when user navigates to Checkboxes page
        * and user clicks on checkbox 1
        * then user verifies that checkbox #1 is selected
        * */
    @Test
    public void selectCheckbox(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(3);
        //#1 way
//        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
//        boolean isButtonSelected = driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected();
//        Assert.assertTrue(isButtonSelected);
        //#2nd way
        List<WebElement>checkboxes=driver.findElements(By.tagName("input")); //CSS input:nth-of-type(1)
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox#1 is not Selected");
        BrowserUtils.wait(3);


    }

    @BeforeMethod
    public void setup(){
        driver=DriverFactory.createDriver("chrome");
        ChromeOptions chromeOptions = new ChromeOptions();

        //Interview Question: how to handle SSL issue in Selenium ==> set accecpt s=certificate
        // !! use to customize browser for tests
        chromeOptions.setAcceptInsecureCerts(true);
        // !! to ignore "your connection is not private issue" warning
        //provide chromeOptions object into chromeDriver constructor
        //

        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}

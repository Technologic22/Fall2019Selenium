package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
       }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void waitForTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 9);
        driver.get("http://google.com");
        //wait up to 9 second till the title is Google
        wait.until(ExpectedConditions.titleIs("Google"));

        driver.navigate().to("http://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));
    }

    @Test
    public void waitForVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver, 9);

        driver.findElement(By.tagName("button")).click();
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("pwd"));
        WebElement submitButton= driver.findElement(By.xpath("//button[text()='Start']"));

        //wait.until(ExpectedConditions.visibilityOfAllElements(username, password, submitButton));
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        String expected= "Welcome to the Secure Area. When you are done click logout below.";
        String actual= driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver, 9);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement checkbox= driver.findElement(By.cssSelector("input[type='checkbox']"));
       // wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();



    }
}

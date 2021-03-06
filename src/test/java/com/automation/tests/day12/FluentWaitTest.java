package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest {
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
    public void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        Wait <WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(9)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);
        //Anonymous class- class without names
        WebElement submitButton = wait.until(WebDriver ->driver.findElement(By.xpath("//button[text()='Submit']")));
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

    }
}

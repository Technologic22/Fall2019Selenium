package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(4);

        driver.findElement(By.name("firstname")).sendKeys("Muhamed");
        BrowserUtils.wait(2);
        driver.findElement(By.name("lastname")).sendKeys("Allakulyyev");
        BrowserUtils.wait(2);
        driver.findElement(By.name("username")).sendKeys("Biohazard");
        BrowserUtils.wait(2);
        driver.findElement(By.name("email")).sendKeys("biomuhammet@mail.ru");
        BrowserUtils.wait(2);
        driver.findElement(By.name("password")).sendKeys("kerki56789");
        BrowserUtils.wait(2);
        driver.findElement(By.name("phone")).sendKeys("718-730-4610");
        BrowserUtils.wait(2);

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click();
        BrowserUtils.wait(2);

        driver.findElement(By.name("birthday")).sendKeys("05/06/1986");
        BrowserUtils.wait(2);

        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(4);

       //driver.get(driver.getCurrentUrl());
       String actual = driver.findElement(By.tagName("h4")).getText();
       String expected = "Well done!";

        System.out.println("actual text "+actual);

        if (actual.equalsIgnoreCase(expected)){
            System.out.println("Test Pass");
        }else {
            System.out.println("Test Fail");
        }

        driver.quit();
    }
}

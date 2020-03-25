package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathContinued {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//label[text()='First name']/..//input")).sendKeys("Aynur, ");
        driver.findElement(By.xpath("//label[text()='First name']/following-sibling::div/input")).sendKeys("Leyla");
        BrowserUtils.wait(2);
        driver.close();


        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("Biohazard");


    }
}

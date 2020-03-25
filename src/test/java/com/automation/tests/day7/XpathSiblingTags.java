package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathSiblingTags {
    static String userNameLocator ="//label[text()='Username']/following-sibling::input";
    static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    static String loginButton = "//button[text()='Login']";
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        //to be more organized Locator stored as static variable
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath(loginButton)).click();

        BrowserUtils.wait(2);
        driver.close();
    }
}

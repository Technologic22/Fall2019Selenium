package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CssSelector {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        System.out.println("<h3 class=\"h3\">Multiple buttons</h3>");  /// h3.h3  or .h3 is enough!!
        driver.findElement(By.cssSelector("h3.h3"));
        BrowserUtils.wait(2);
        System.out.println("<button class=\"btn btn-primary\" onclick=\"button1()\" wfd-id=\"19\">Button 1</button>");
        driver.findElement(By.cssSelector("button[onclick='button1()']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("button[onclick='button2()']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[id^='button_']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[onclick='button4()']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[onclick='button5()']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("#disappearing_button")).click();
        BrowserUtils.wait(2);

        System.out.println("<a class=\"nav-link\" href=\"/\">Home</a>");
        driver.findElement(By.cssSelector(".nav-link")).click();   // also   '   a[href='/']  '


        BrowserUtils.wait(2);
        driver.quit();
    }
}

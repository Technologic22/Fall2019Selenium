package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


        //if there are some space inside text use partialLinkText (it is like Contains method rather than equals method)
        //logout button is actually a link, not a button!
        //every element with <a>tag is a link
        //partialLinkText - not complete match required!
        WebElement logout = driver.findElement(By.linkText("Logout"));

        String href = logout.getAttribute("href");

        System.out.println(href);

        logout.click();
        Thread.sleep(4000);

        // driver.quit();

    }
}

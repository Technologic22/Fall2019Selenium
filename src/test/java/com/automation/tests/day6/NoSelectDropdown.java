package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown
        // it is not actually dropdown here!
        BrowserUtils.wait(2);

        List <WebElement> links = driver.findElements(By.className("dropdown-item"));


        for (WebElement eachLink : links) {
            System.out.println(eachLink.getText()+": "+eachLink.getAttribute("href"));
            BrowserUtils.wait(1);
        }

        //<a class="dropdown-item" href="https://www.yahoo.com/">Yahoo</a>
        driver.findElement(By.linkText("Etsy")).click();  //click on your option
        BrowserUtils.wait(4);



        driver.close();
    }
}

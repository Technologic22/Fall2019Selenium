package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {

        //setup Chrome driver
        WebDriverManager.edgedriver().setup();

        //Create Chromedriver Object
        EdgeDriver driver = new EdgeDriver();

        //open some website
        driver.get("http://mail.yahoo.com");



    }
}

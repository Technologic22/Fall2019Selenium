package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        //to start Se script we need:
       //a- setup webdriver and b-create webdriver object

               WebDriver driver = new ChromeDriver();
               // in SE everything starts from webdriver interface


        //polymorphism starts here
        //RemoteWebDriver is super class of browser drivers

        driver.get("http://google.com"); //to open webpage

        driver.manage().window().maximize();  // to maximize windows
        driver.manage().window().fullscreen();

        Thread.sleep(4000); //for demo purpose only!!!

        //U can also see it as tab name: It returns title
        String title = driver.getTitle();// <title> Some Title </title> text
        System.out.println(title);

        String expectedTitle = "Google";

        if (expectedTitle.equals(title)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Fail");
        }

        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        Thread.sleep(3000);

        driver.close(); // Browser doesnt close itself

    }
}

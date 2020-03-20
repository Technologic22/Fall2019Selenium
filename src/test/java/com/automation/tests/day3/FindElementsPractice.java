package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));

        fullName.sendKeys("Reda Morocco");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("biomuhammet@mail.com");

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));

        //when U see submit U can use sumbit too, when click doesnt work!!!


        //signUp.submit();

        signUp.click();

        driver.quit();



    }
}

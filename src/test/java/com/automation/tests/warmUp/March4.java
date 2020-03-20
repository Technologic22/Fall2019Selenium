package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Arrays;

public class March4 {



    public static void main(String[] args) throws Exception{

        eBayTest();
        amazonTest();
        wikiTest();


    }

    public static void eBayTest() throws Exception{
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://ebay.com");
        Thread.sleep(2000);

        driver.findElement(By.id("gh-ac")).sendKeys("Java");;
        Thread.sleep(3000);

        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);

       System.out.println("Number of Found items: " + driver.findElement(By.tagName("h1")).getText().split(" ")[0]);

    }


    public static void amazonTest () throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://amazon.com");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        Thread.sleep(3000);

        if (driver.getTitle().contains("Java")){

            System.out.println("SUCCESS");
        } else {
            System.out.println("Fail");
        }
    }


    public static void wikiTest() throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://wikipedia.org");
        Thread.sleep(2000);

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.linkText("Selenium (software)")).click();
        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        String [] url = driver.getCurrentUrl().split("/");
        System.out.println(Arrays.toString(url));
        System.out.println(url[url.length-1]);

        if ((url[url.length-1]).equalsIgnoreCase("Selenium_(software)")){
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }


    }

}

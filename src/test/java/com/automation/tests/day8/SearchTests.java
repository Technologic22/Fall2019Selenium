package com.automation.tests.day8;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("http://google.com");
        BrowserUtils.wait(4);
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);

        BrowserUtils.wait(5);

       List<WebElement>searchItems=driver.findElements(By.tagName("h3"));

        for (WebElement eachItem : searchItems) {
            String  word=eachItem.getText();
                    //if there is a text print it
            if (!word.isEmpty() && word.toLowerCase().contains("java")){
                System.out.println("word = " + word);

                Assert.assertTrue(true);
            }


        }
    }

    @Test (description = "Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");


    }

    @BeforeMethod       //setup webdriver
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }

    @AfterMethod     //close browser and destroy webdriver  + Cleanupp
    public void teardown() {
        BrowserUtils.wait(3);
       // driver.quit();
    }

}

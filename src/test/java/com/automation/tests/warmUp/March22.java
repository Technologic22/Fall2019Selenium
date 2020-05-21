package com.automation.tests.warmUp;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class March22 {
    private WebDriver driver;

        /**
         * Go to http://practice.cybertekschool.com/tables
        Click on "Last name" column name
        Verify that table is sorted by last name in alphabetic order.
         */


    @Test
    public void alphabeticalOrder(){
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(4);
        List<String > expected= Arrays.asList("Bach", "Conway", "Doe", "Smith");
        List<WebElement>elements=driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int i = 0; i <elements.size()-1 ; i++) {

            String value=elements.get(i).getText();
            String nextValue=elements.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextValue)<0);
        }

//        List<String> actual= new ArrayList<>();
//        for (WebElement eachItem:elements) {
//            actual.add(eachItem.getText());
//        }
//        Assert.assertEquals(actual, expected);


    }

    @BeforeMethod
    public void setup(){
        driver=DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
        driver.get("http://practice.cybertekschool.com/tables");
        BrowserUtils.wait(4);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.close();
        driver=null;
    }
}

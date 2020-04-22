package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;
import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;

    @Test(description = "choose specific data cells!")
    public void getColumnNames(){
                //  !! th - represents tab\le header!
           List<WebElement>columnNames=driver.findElements(By.xpath("//table[1]//th"));

        for (WebElement columnName:columnNames) {
            System.out.println(columnName.getText());
        }

        List<String> expected= Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);

    }

    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        // if we get a size of this collection, it automatically equals to number of elements

        Assert.assertEquals(rows.size(), 4);

    }

    /*
    * to select specific column, skip row, and just provide td index
     */

    @Test
    public void getSpecificColumn(){
        List<WebElement> links=driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));


    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }
}

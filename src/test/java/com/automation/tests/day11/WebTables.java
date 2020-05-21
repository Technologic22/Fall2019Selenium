package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;
import java.util.ArrayList;
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
        System.out.println(BrowserUtils.getTextFromWebElements(links));

    }

    @Test
    public void deleteRowTest(){
        String xPath="//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xPath)).click();
        int rowCount=driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());
    }

    @Test (description = "lets write a function that return Column name based on index")
    public void getColumnIndexByName(){
        String columnName = "Email";
        int emailIndex=0;
        List <WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));

        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i+1));
            if (actualColumnName.equalsIgnoreCase(columnName)){
                System.out.println("Index of Emails is = " + (i+1));
                emailIndex=i+1;
                break;
            }
        }
        Assert.assertEquals(emailIndex,3);
    }

    @Test
    public void getSpecificCell(){
        int row = 3;
        int column = 5;
        String xPath="//table[1]//tbody//tr["+row+"]//td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xPath));
        String expected ="http://www.jdoe.com";

        System.out.println("Actual: "+cell.getText());
        Assert.assertEquals(cell.getText(), expected);
    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless(true);   // to run browser w/out GUI

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

package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        wait= new WebDriverWait(driver, 9);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    /**
     * Go to page
     * Click 'Check all' button
     * verify all boxees selected
     */
    @Test
    public void checkBoxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List <WebElement> elements= driver.findElements(By.xpath("ctl00_MainContent_btnCheckAll"));
        for (WebElement eachElement: elements) {
            Assert.assertTrue(eachElement.isSelected());
        }
    }

    /**
     * Go to page Weborder page
     * verify steve johns zip code is 21233
     * then update his zip code to 20002
     * verify zipcode is updated
     */

    @Test
    public void updateZipcodeTest(){
    String oldZipcode= "21233";
    String expectedZipcode= driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText();
    Assert.assertEquals(oldZipcode, expectedZipcode);
    driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td//input")).click();
    driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).clear();
    driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("20002");
    driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
    String newZipcode= driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText();
    String newExpectedZip="20002";
    Assert.assertEquals(newExpectedZip, newZipcode);

    }
}

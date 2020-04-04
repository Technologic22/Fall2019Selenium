package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;
    private By img1By=By.xpath("(//img)[1]");
    private By img2By=By.xpath("(//img)[2]");
    private By img3By=By.xpath("(//img)[3]");



    @Test
    public void hoverTest(){

        BrowserUtils.wait(2);
        //build() is needed when U have couple of actions
        //always end with Perform()
        WebElement img1=driver.findElement(img1By);
        WebElement img2=driver.findElement(img2By);
        WebElement img3=driver.findElement(img3By);

        actions.moveToElement(img1).pause(1500).
                moveToElement(img2).pause(1500).
                moveToElement(img3).pause(2000).
                build().perform();

        BrowserUtils.wait(2);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(driver.findElement(By.xpath("(//h5)[1]")).isDisplayed());
        BrowserUtils.wait(2);
        actions.moveToElement(img2).perform();
        Assert.assertTrue(driver.findElement(By.xpath("(//h5)[2]")).isDisplayed());
//        actions.moveToElement(img3).perform();
//        Assert.assertTrue(driver.findElement(By.xpath("(//h5)[3]")).isDisplayed());
    }

    @Test
    public void jQueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtils.wait(3);
        actions.moveToElement(driver.findElement(By.id("ui-id-3"))).pause(3000).moveToElement(driver.findElement(By.
                id("ui-id-4"))).pause(3000).moveToElement(driver.findElement(By.id("ui-id-5"))).
                pause(3000).click().build().perform();

        //Assert.assertTrue(driver.findElement(By.id("ui-id-5")).isDisplayed());
    }


    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual, expected);

    }


    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(4);
        actions= new Actions(driver);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
        driver=null;

    }
}

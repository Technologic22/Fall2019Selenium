package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {
    private WebDriver driver;


    @Test
    public void getTitle(){
        String actual=driver.getTitle();
        String expected="Practice";
        //assertEquals(actual, expected);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //we create javascriptexecutor object by casting webdriver object
        String pageTitle = (String) js.executeScript("return document.title");
        String pageTitle2= js.executeScript("return document.title").toString();
        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return document.title - javascript code
        //document - represents HTML page
        //.toString() - to avoid additional casting from Object to String

        assertEquals(pageTitle,expected);
    }

    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        BrowserUtils.wait(2);
        //link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", link);
        //after "", Webelement can be added as "var args" - so U can list any number
        // as part of JS code,
        //arguments listed after (,-comma!) use index to get specific webelement
        //Webelement arguments = {element, link, link2, link3}
        BrowserUtils.wait(3);
        WebElement button6= driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);  //argument[0]=button6,0-Bc its the first element after comma
        BrowserUtils.wait(3);

        WebElement result = driver.findElement(By.id("result"));

        assertEquals(result.getText(), "Now it's gone!");

    }

        @Test
        public void textInputTest(){
        WebElement form=driver.findElement(By.linkText("Form Authentication"));
        BrowserUtils.wait(1);
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", form);   //form.click();

        BrowserUtils.wait(3);
        WebElement username= driver.findElement(By.name("username"));
        WebElement password= driver.findElement(By.name("password"));
        WebElement loginButton=driver.findElement(By.id("wooden_spoon"));
        //to get text from input box - get attribute value
        //to enter text, set attribute value
        js.executeScript("arguments[0].setAttribute('value','tomsmith')", username, password);
        BrowserUtils.wait(2);
//      js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password); // U can use either
        js.executeScript("arguments[1].setAttribute('value','SuperSecretPassword')", username, password);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", loginButton);
        BrowserUtils.wait(2);
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String subheader=js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        assertEquals(subheader, expected);
        BrowserUtils.wait(3);
        }



    @Test
        public void scrollToElement(){
        BrowserUtils.wait(4);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", link);

        }

        @Test
        public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js=(JavascriptExecutor) driver;

            for (int i = 0; i <20 ; i++) {
                js.executeScript("window.scrollBy(0, 1500)");
                BrowserUtils.wait(1);
            }

        }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
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

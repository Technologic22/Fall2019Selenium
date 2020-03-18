package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(5000);

                //By.name("q") means ==> name = "q"
        WebElement search = driver.findElement(By.name("q"));

        //once we find an element, how to enter text?
        // to enter text use sendKeys() method;
        //how to press Enter after typing text?
        //use Keys.ENTER & performs Keyboard 'Enter' click

        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep (3000);

        //if U see <a  > it calls a link
        //visible text f this link will be used by SE to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click(); // used toclick on the element
        Thread.sleep(4000);

        driver.quit();

    }
}

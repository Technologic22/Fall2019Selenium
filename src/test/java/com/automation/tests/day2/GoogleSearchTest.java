package com.automation.tests.day2;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        BrowserUtils.wait(4);
                //By.name("q") means ==> name = "q"
        WebElement search = driver.findElement(By.name("q"));

        //once we find an element, how to enter text?
        // to enter text use sendKeys() method;
        //how to press Enter after typing text?
        //use Keys.ENTER & performs Keyboard 'Enter' click

        search.sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);

        //if U see <a  > it calls a link
        //visible text f this link will be used by SE to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click(); // used toclick on the element
        BrowserUtils.wait(4);

        driver.quit();

    }
}

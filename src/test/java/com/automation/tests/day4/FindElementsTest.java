package com.automation.tests.day4;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.wait(2);

        //How to collect all links from the page
        // all links have <a> tag
        List <WebElement> links = driver.findElements(By.tagName("a"));

        //How to get text from each link

        for (WebElement link: links) {

            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
//            link.click();
//            Thread.sleep(2000);
//            driver.navigate().back();

        }

        //Interview QUESTION: what is Stale Elements Exception!!!

        for (int i = 1; i < links.size(); i++) {

            links.get(i).click();
            BrowserUtils.wait(2);
            driver.navigate().back();
            BrowserUtils.wait(2);
           links=driver.findElements(By.tagName("a"));  ///

        }
            driver.quit();

    }
}

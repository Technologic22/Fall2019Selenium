package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);

        //How to collect all links from the page
        // all links have <a> tag
        List <WebElement> links = driver.findElements(By.tagName("a"));

        //How to get text from each link

        for (WebElement link: links) {

            System.out.println(link.getText());

        }



    }
}

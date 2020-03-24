package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    /**     Interview Question!!!
     *
     * how to check if element is gone/doesnt exist any more?!
     *
    * */
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        //if size is "0", means no more that element exists
        if (driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("Test PAss");
        }else {
            System.out.println("Fail");
        }
                    Thread.sleep(3000);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement button : buttons){

            button.click();
            Thread.sleep(2500);
        }

        Thread.sleep(3000);
        driver.quit();

    }

}

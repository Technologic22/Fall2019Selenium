package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

        WebElement progLanguage = driver.findElement(By.name("Languages"));
        Select yourLanguage = new Select(progLanguage);
        boolean isMultiple = yourLanguage.isMultiple();  // WE NEED TO CHECK WHETHER THIS SUPPORTS multiple selection
        System.out.println(isMultiple);
        System.out.println();

        yourLanguage.selectByVisibleText("C#");
        yourLanguage.selectByVisibleText("Java");

        //to check whether we have selected multiple object is correct
        List<WebElement>selectedOptions = yourLanguage.getAllSelectedOptions();


         for (WebElement yourOption : selectedOptions ){
             System.out.println(yourOption.getText());
         }

            System.out.println();
            yourLanguage.deselectByVisibleText("Java");  //to unselect option
            BrowserUtils.wait(2);
            yourLanguage.deselectAll();



        BrowserUtils.wait(2);
        driver.quit();
    }
}

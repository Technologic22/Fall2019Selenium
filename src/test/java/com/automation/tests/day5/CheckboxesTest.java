package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class CheckboxesTest {
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(4);

        //Verify that 1st is not selected and 2nd one is selected

        List <WebElement> checkboxes = driver.findElements(By.tagName("input"));



        if (!checkboxes.get(0).isSelected() && checkboxes.get(1).isSelected()){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        BrowserUtils.wait(2);

       WebElement checkbox1 = checkboxes.get(0);
       checkbox1.click();  //click 1st checkbooox

        if (checkbox1.isSelected()){
            System.out.println("Pass");
            System.out.println("Checkbox #1 is selected");
        }else {
            System.out.println("Fail");
            System.out.println("Checkbox #1 is not selected");
        }

        BrowserUtils.wait(2);
        driver.close();

    }
}

package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(4);

        List <WebElement> checkboxes = driver.findElements(By.tagName("input"));

        checkboxes.get(0).click();  //1st checkbx clicked
        BrowserUtils.wait(2);

        checkboxes.get(1).click();   //2nd checkbox clicked
        BrowserUtils.wait(2);

        for (int i = 0; i < checkboxes.size() ; i++) {

            //if visible, eligible and not clicked
            if (checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled() && (!checkboxes.get(i).isSelected())) {
                //if checkbox is not selected, click on it
                checkboxes.get(i).click(); // click on the second one
            }else {
                System.out.println(i+1 + " checkbox was not clicked");
            }
        }



        BrowserUtils.wait(3);
        driver.quit();
    }
}

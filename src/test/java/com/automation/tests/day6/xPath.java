package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xPath {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
                //Value can be inside single ('') or double("") quotes
                //if You dont know the tag name just use '*' -star i.e.(//*[@onclick="button1()"])
                //* any tag name

        String clickResult = driver.findElement(By.id("result")).getText();
        System.out.println(clickResult  );

        //click button 2 based on text Xpath
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[text()='Button 2']")).click();
        System.out.println(driver.findElement(By.id("result")).getText());

        //click button 3 based on Starts-With Method since its id is changing each time
        ////button[starts-with(@id, 'button_')]
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[starts-with(@id, 'button_')]")).click();
        System.out.println(driver.findElement(By.id("result")).getText());

        //click button 4 based on Contains Method & text
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[contains(text(), 'Button 4')]")).click();
        System.out.println(driver.findElement(By.id("result")).getText());

        //click button 5 based on Contains Method & Attribute Value
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[contains(@onclick, 'button5()')]")).click();
        System.out.println(driver.findElement(By.id("result")).getText());

        //if there are more than one Xpath with contains method, use Index of button(tag)
        //i.e: //button[index] or (//button)[index]

        //click button 6 based on Contains Method & partial attribute value and index of button
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[contains(@id, '_button')][2]")).click();
        System.out.println(driver.findElement(By.id("result")).getText());




        BrowserUtils.wait(2);
        driver.close();
    }
}

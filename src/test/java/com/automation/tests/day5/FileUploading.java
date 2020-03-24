package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FileUploading {
    public static void main(String[] args) throws Exception{
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);

                        //----JAVA SYSTEM PROPERTIES-----//
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //to upload pom.xml file

        String filePath = System.getProperty("user.dir")+"/pom.xml";
        String file2Path = "C:\\Users\\biomu\\Downloads\\IMG_20160613_0822371.jpg";
        driver.findElement(By.id("file-upload")).sendKeys(file2Path);

        System.out.println(filePath);

        BrowserUtils.wait(3);
        driver.quit();
    }
}

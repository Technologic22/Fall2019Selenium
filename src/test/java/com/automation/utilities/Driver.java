package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.invoke.SwitchPoint;

public class Driver {
    //same for everyone
    private static WebDriver driver;
    private Driver(){}

    public static WebDriver getDriver(){
        //If webdriver object doesnt exist Create it
        String browser = ConfigurationReader.getProperty("browser").toLowerCase();
        //specify browser type in configuration.properties file

        if (driver==null){
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default: throw new RuntimeException("Wrong browser name!");

            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}

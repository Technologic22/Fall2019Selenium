package com.automation.tests.day2;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class quitVsClose {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        BrowserUtils.wait(4);

        driver.close(); // wil close only onewindow

        driver.quit();  // all windows tabs are closed!



    }
}

package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some id, this is called window handle
        //based on windows handle, we can swtich between windows

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        //used to get windows IDs of currently opened windows
        //Set doesnt allow duplicates


        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);

        System.out.println("Before Swithcing Windows: "+driver.getCurrentUrl());

        //since we know all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window id

        for (String windowId : windowHandles){
            //if its not old windows, then switch
            if (!windowId.equals(windowHandle)){
                //to jump to thenew window
                driver.switchTo().window(windowId);

            }
        }

        System.out.println("After Switching: " +driver.getCurrentUrl());

            driver.close();

    }

        /*
        * This method helps to switch in betwen windows based on page Title
        * */


    public static void switchToWindowBasedOnTitle (String pageTitle, WebDriver driver){

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }


    }

}

package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {
    public static void wait (int seconds) {
        try {
                Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an Element using JS executor
     *
     * @param element
     */
    public static void clickWithJS (WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     *
     * @param elements- represents collection of web elements
     * @return - collection os Strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List <String> textValues=new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()){
            textValues.add(element.getText());
            }
        }
        return textValues;
    }

    public static void scrollTo(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     *
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot (String name){
       //adding date and time to screenshot name, to make screen shot unique
        name=new Date().toString().replace(" ", "_").replace(":","_") +"_"+name;
        // where we gonna store screenshot
        String path="";
        if (System.getProperty("os.name").toLowerCase().contains("mac")){
            path=System.getProperty("user.dir")+"/test-output/screenshots"+name+".png";
        }else {
            path=System.getProperty("user.dir")+"\\test-output\\screenshots\\"+name+".png";
        }
        System.out.println("OS name: "+System.getProperty("os.name"));
        System.out.println("Screenshot Path: "+path);
        //Since our reference type is WebDriver, we cannot see methods from Interface TakeScreenshot
        //that is why we do casting as in JS executor
        TakesScreenshot takesScreenshot= (TakesScreenshot) Driver.getDriver();
        //- takes screenshot of web Browser and saves as a .png file
        File source= takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination= new File(path);  // directory where to savescreenshot
        try {
            FileUtils.copyFile(source, destination);                /// copying file to previously defined location
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
}

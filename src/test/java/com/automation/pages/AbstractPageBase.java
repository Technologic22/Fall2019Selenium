package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be extended by page classes
 * Common locators /webelements can be stored here
 * Since Navigatiuon menu doesnt belong to particular page
 * we can't create a dedicated page class to store elements from that menu
 */

public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait= new WebDriverWait(driver, 15);

    @FindBy (css = "#user-menu >a")
    protected WebElement currentUser;

    public AbstractPageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getCurrentuserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * Method for Vytrack navigation. Provide tab name and module name to navigate
     * @param tabName  like Dashboards, Fleet, Customers
     * @param moduleName like Vehicles, Accounts, Vehicles Odometer and Vehicle Costs
     */
    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath= "//span[@class='title title-level-1' and contains (text(),'" +tabName+"')]";
        String moduleNameXpath= "//span[@class='title title-level-2' and text()='" +moduleName+"']";

        WebElement tabElement= driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement=driver.findElement(By.xpath(moduleNameXpath));

        Actions actions = new Actions(driver);
        BrowserUtils.wait(4);
        actions.moveToElement(tabElement).pause(3000).
                click(moduleElement).
                build().perform();
        BrowserUtils.wait(6);  //increase wait time if still failing!


    }
}

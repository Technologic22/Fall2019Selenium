package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id="prependedInput")
    private WebElement username;

    //if Find By not used:  public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy (id= "prependedInput2")
    private WebElement password;

    @FindBy (id="_submit")
    private WebElement login;

    @FindBy (linkText= "Forgot your password?")
    private WebElement forgotPassword;

    public LoginPage(){
        //to connect our WebDriver, page class and page factory
        //pageFactory - used to use @FindByAnnotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);    // u can also use This=LoginPage.class
                  //initelements - required to put into constructor of every page class
    }

    /**
     *  Method to login, version #1
     *  login as 'specific' user
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials retrieved from configuration.properties file
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("storemanager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.wait(3);
    }

}

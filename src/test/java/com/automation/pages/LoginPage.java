package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id="prependedInput")
    public WebElement username;

    @FindBy (id= "prependedInput2")
    public WebElement password;

    @FindBy (id="_submit")
    public WebElement login;

    @FindBy (linkText= "Forgot your password?")
    public WebElement forgotPassword;

    public LoginPage(){
        //to connect our WebDriver, page class and page factory
        //pageFactory - used to use @FindByAnnotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);    // u can also use This=LoginPage.class
                  //initelements - required to put into constructor of every page class
    }
}

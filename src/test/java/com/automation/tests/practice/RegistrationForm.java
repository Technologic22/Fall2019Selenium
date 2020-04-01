package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL="http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy=By.cssSelector("input[name='firstname']");
    private By lastNameBy=By.cssSelector("input[name='lastname']");
    private By usernameBy=By.cssSelector("input[name='username']");
    private By emailBy=By.cssSelector("input[name='email']");
    private By passwordBy=By.cssSelector("input[name='password']");
    private By phoneBy=By.cssSelector("input[name='phone']");
    private By genderBy=By.xpath("//input[@value='male']");
    private By birthdayBy= By.xpath("//input[@name='birthday']");
    private By cPlusPlus=By.xpath("//label[text()=\"C++\"]/preceding-sibling::input");
    private By javaBy=By.xpath("//label[text()=\"Java\"]/preceding-sibling::input");
    private By javaScriptByy=By.xpath("//label[text()=\"JavaScript\"]/preceding-sibling::input");



    @Test(description = "verify message displayed: You've successfully completed registration!")
    public void test1(){

        driver.findElement(firstNameBy).sendKeys("Aynur");
        BrowserUtils.wait(1);
        driver.findElement(lastNameBy).sendKeys("Allakulyyeva");
        BrowserUtils.wait(1);
        driver.findElement(usernameBy).sendKeys("LeylaAAA");
        BrowserUtils.wait(1);
        driver.findElement(emailBy).sendKeys("biomm@mail.ru");
        BrowserUtils.wait(1);
        driver.findElement(passwordBy).sendKeys("123456789");
        BrowserUtils.wait(1);
        driver.findElement(phoneBy).sendKeys("718-730-4610");
        BrowserUtils.wait(1);
        driver.findElement(genderBy).click();
        BrowserUtils.wait(1);
        driver.findElement(birthdayBy).sendKeys("05/06/1986");
        BrowserUtils.wait(1);

        Select department = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByValue("TRO");
        BrowserUtils.wait(1);

        Select jobTitle= new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(3);
        BrowserUtils.wait(1);

        driver.findElement(javaBy).click();
        driver.findElement(javaScriptByy).click();
        BrowserUtils.wait(1);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(4);

        String actual = driver.findElement(By.xpath("//p")).getText();
        String expected = "You've successfully completed registration!";

        assertEquals(actual, expected);

       }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

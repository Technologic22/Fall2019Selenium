package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is "Dashboard"
     */

    @Test (groups = "smoke")
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add every test at the beginning
        //test = report.createTest("Test name")
        test=report.createTest("Verify Page Title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //'info' is like system.out, but it goes to report as well
        test.info("Login as Store Manager");    //log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set the test status to passed in reports
        test.pass("Page title Dashboard was verified");
    }

/**
 * Enter wrong credentials and verify waring message
 */

    @Test
    public void verifyWarningMessage(){
                 test=report.createTest("Verify Warning Message");
                LoginPage loginPage= new LoginPage();
                loginPage.login("Storemanager100", "12345");
                Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
                //take a screenshot
                BrowserUtils.getScreenshot("warning_message");
                test.pass("Warning message is displayed");
    }

    @Test(dataProvider="credentials")
    public void loginWithDDT(String userName, String password){

        test=report.createTest("Verify Page Title as "+userName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " +userName);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");

    }

    //Object [][] or Object[] or Iterator <Object[]>
    //Object[] - 1 column wth date
    //Object [][] - 2+
    @DataProvider
    public Object [][] credentials(){
    return new Object[][]{{"storemanager85",  "UserUser123"},
                          {"salesmanager110", "UserUser123"},
                          {"user16",          "UserUser123"}
        };
    }

    @Test (dataProvider = "credentialsfromExcelFile")
    public void loginTestWithEcel(String execute, String username, String password, String firstname, String lastname, String result){
        if (execute.equals("y")){
            LoginPage loginPage=new LoginPage();
            loginPage.login(username, password);
            test.info("Login as "+username);  //--log some steps
            test.info(String.format("First name: %s, Last name: %s, Username: %s"));
            test.pass("Successfully logged in as "+username);
        }else {
            test.skip("Test was skipped for user "+username);
            //to skip some test in testng
            throw new SkipException("Test was skipped");
        }
    }

    //Execute   username    password    firstname     lastname     result
    @DataProvider
    public Object[][] credentialsFromExcelFile(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA3-short";
        ExcelUtil excelUtil= new ExcelUtil(path, spreadSheet);
        //--Execute   username    password    firstname     lastname     result
        return excelUtil.getDataArray();
    }


}

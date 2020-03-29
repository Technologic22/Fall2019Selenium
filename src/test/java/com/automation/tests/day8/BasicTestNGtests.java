package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGtests {

    @BeforeTest   //runs only once before @BeforeMethod and @BeforeClass

    public void beforeTest(){
        System.out.println("+++++++Before Test+++++++");
    }

    @AfterTest   //runs only once before @AfterMethod and @AfterClass
    public void afterTest(){
        System.out.println("+++++++After Test+++++++");
    }


    @BeforeClass             ///Runs only once, before anything, regardless of test numbers or methods
    public void beforeClass(){
        System.out.println("------Before class-------");
    }

    @AfterClass      /// something shd be done just once afterr all methods or tests inthe class
    public void afterClass(){
        System.out.println("-------After Class-------");
    }

    //runs before every test automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("---Before Each Method---");
    }

    @AfterMethod           //runs automatically after each method
    public void teardown(){
        System.out.println("---After Method---");
    }

    @Test (description = "verify equality check")
    public void test1 (){
        System.out.println("Test-1");
        String expected="rac";
        String actual=UnitTestPractice.reverseString("car");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2 (){
        System.out.println("Test-2");
        int num1 = 5;
        int num2 = 6;

        //it is called hard assertion
        //if it fails, stops execution - due to exception
        Assert.assertTrue(num1<num2);

    }

}

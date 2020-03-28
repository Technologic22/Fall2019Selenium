package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {


    public static void main(String[] args) {

        //Unit Test:
        //to check if out nmethod works properly
        //if assertions fails, our method doesnt work correctly, we have to fix it

        System.out.println(reverseString("Battle"));

        String expected="elppA";
        String toReverse="Apple";
        String actual = reverseString(toReverse);

        //Assertion
        verifyEquality(expected, actual);

    }

    @Test  (description = "verify if methhod can reverse a string!")   //Annotation
    public void test(){
                    String expected="ABC";
                    String actual = reverseString("CBA");
             //Assert class is coming from TestNG(also Junit!)
        //to compare any data types: string, char, int, double, arrays, objects
        //to verify if expct = actual

        Assert.assertEquals(expected, actual);
    }

    public static boolean verifyEquality(String expected, String actual){

        if (expected.equals(actual)){
            System.out.println("Test Pass");
            return true;
        }else {
            System.out.println("Test Fail");
            System.out.println("Expected: " +expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

    public static String reverseString(String str){

        String reversed="";

        for (int i = str.length()-1; i >=0 ; i--) {


            reversed=reversed+str.charAt(i);

        }
            return reversed;

    }

}

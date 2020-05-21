package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void Test(){
        //C:\Users\biomu\IdeaProjects\Fall2019Selenium\pom.xml
        //System.getProperty("user.dir")+"/pom.xml"
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));;
        //System.getProperty("user.home")+"/Downloads"
        System.out.println(System.getProperty("user.home"));
        String pathToDownloads=System.getProperty("user.home")+"/Downloads";
        System.out.println(pathToDownloads);
        System.out.println(System.getProperty("os.arch"));

        //SYSTEM PROPERTIES https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

    }
}

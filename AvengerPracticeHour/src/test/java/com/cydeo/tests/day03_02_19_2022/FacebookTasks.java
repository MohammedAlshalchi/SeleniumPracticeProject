package com.cydeo.tests.day03_02_19_2022;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FacebookTasks {
    /*
    TC #1: Facebook title verification

     */


WebDriver driver;
    @BeforeMethod
    public void setUp() {
       // 1. Open Chrome browser

         driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // 2. Go to https://www.facebook.com
         driver.get("https://www.facebook.com");

    }

    @Test
    public void TC1_verifying_title() {
        //3. Verify title:
       // Expected: “Facebook - Log In or Sign Up
      String expectedTitle = "Facebook - Log In or Sign Up" ;
      String actualTitle = driver.getTitle();
      assertEquals(actualTitle,expectedTitle);


   }


/*
TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
 */

    @Test
    public void TC2_verifying_login_title() {

//        3. Enter incorrect username
 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("incorrect");


//        4. Enter incorrect password
    driver.findElement(By.xpath("//div[@id='passContainer']/input")).sendKeys("incorrect"+ Keys.ENTER);


//        5. Verify title changed to:
        // Expected: “Log into Facebook”
        String expectedTitle ="Facebook - Log In or Sign Up";
String actualTiTle = driver.getTitle();
   assertEquals(actualTiTle,expectedTitle);//   WE IMPORT THE method LINE 16


    }



    /*
    TC #3: Facebook header verification
1. Open Chrome browser
2. Go to https://www.facebook.com


     */

    @Test
    public void TC3_verifying_header() {
       // 3. Verify header text is as expected:
String expectedHeader = "Connect with friends and the world around you on Facebook.";
String actualHeader = driver.findElement(By.cssSelector("h2._8eso")).getText();
        //Expected: “Facebook helps you connect and share with the people in your life."
assertEquals(actualHeader,expectedHeader,"verifying header");
        //assertEquals(actualHeader, expectedHeader);


    }

@Test
public void TC4_verifying_link_attribute (){

/*
TC #4: Facebook header verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify “Create a page” link href value contains text:

Expected: “registration_form"
 */
String  expectedWord="registration_form";
String actualAtributeValue= driver.findElement(By.xpath("//a[contains(@href,'regist')]")).getAttribute("href");
assertTrue(actualAtributeValue.contains(expectedWord));
}









    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}

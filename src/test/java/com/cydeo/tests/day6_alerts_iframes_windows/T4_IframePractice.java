package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {

WebDriver driver;



//3. Go to: https://practice.cydeo.com/iframe
//            4. Assert: “Your content goes here.” Text is displayed.
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

@BeforeMethod
    public void  setupMethod () {

//    TC #4: Iframe practice
     //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://practice.cydeo.com/iframe");

}

//@Ignore ====> we use it if we do not want to run the test
    @Test

 public void iframe_test (){


//We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");
        //option #2- passing index number of iframe
        //driver.switchTo().frame(0); ===>count start from 1 ( when we have 1 from 1 means :1-1=0 )
        //option #3- locate as web element and pass in frame() method
        // to CHECK if there is iframe or not we can write iframe in the search bar
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

    //Locate the p tag
WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());


         //Verify "An iFrame containing the TinyMCE WYSIWYG Editor"
        //To be able to verify the header, we must switch back to "main HTML"
driver.switchTo().parentFrame();
WebElement  headerText = driver.findElement(By.xpath("//h3"));

//assertion of header text is displayed or not
        Assert.assertTrue(headerText.isDisplayed());



    }


























}

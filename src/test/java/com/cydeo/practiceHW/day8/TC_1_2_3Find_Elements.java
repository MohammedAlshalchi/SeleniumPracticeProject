package com.cydeo.practiceHW.day8;

import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_1_2_3Find_Elements {
    /*
    TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332

TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page

TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109

NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR VERIFICATION.
     */

    public WebDriver driver;

    @BeforeMethod
    public void setUp (){
String browserType = ConfigurationReader.getProperty("browser");
driver = WebDriverFactory.getDriver(browserType);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get(ConfigurationReader.getProperty("env2"));

    }
//
//
//@AfterMethod
//    public void tearDown (){
//        driver.quit();
//}


@Test
    public void links (){
        //TC1
   // List<WebElement> linksNumber = driver.findElements(By.tagName("a"));
    List<WebElement> linksNumber = driver.findElements(By.xpath("//a"));
    int actualCount = linksNumber.size();
    int expectedCount = 326;
    System.out.println("actualCount = " + actualCount);
   Assert.assertEquals(actualCount,expectedCount);
//TC2
    for (WebElement allLinks : linksNumber) {

        try {
            System.out.println("Link text is: "+allLinks);
        }catch (StaleElementReferenceException e){

        }
    }


//TC3
    int count =0;
    for (WebElement emptyLink : linksNumber) {
       try {
           if (emptyLink.getText().isEmpty()){
               count++;
           }
       }catch (StaleElementReferenceException e){

       }
    }
    System.out.println("Number of empty links: "+count);
Assert.assertTrue(count == 229);


}
































}

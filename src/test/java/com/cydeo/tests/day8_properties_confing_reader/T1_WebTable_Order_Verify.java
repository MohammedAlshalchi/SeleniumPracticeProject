package com.cydeo.tests.day8_properties_confing_reader;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {
  /*
  TC #1: Web table practice
 1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
   */

    public WebDriver driver;


    @BeforeMethod
    public void setUpMethod (){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");


    }







   @Test
    public void order_name_verify_test(){

       //Locate the cell that has Bob Martin text in it.
      WebElement bobMartinCell =
               driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

       //  System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

       //2. Verify Bob’s name is listed as expected.
       //Expected: “Bob Martin”
       String expectedBobName = "Bob Martin";
       String actualBobName = bobMartinCell.getText();

       Assert.assertEquals(actualBobName, expectedBobName);

       //3. Verify Bob Martin’s order date is as expected
       //Expected: 12/31/2021
       // alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"


       WebElement bobMartinDateCell =
               driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

       String expectedBobDate = "12/31/2021";
       String actualBobDate = bobMartinDateCell.getText();

       Assert.assertEquals(actualBobDate, expectedBobDate);








   }













































}

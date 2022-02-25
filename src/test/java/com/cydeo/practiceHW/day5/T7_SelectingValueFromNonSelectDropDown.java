package com.cydeo.practiceHW.day5;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_SelectingValueFromNonSelectDropDown {
  /*
   TC #7: Selecting value from non-select dropdown

4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”

   */
    WebDriver driver;

    @BeforeMethod
    public void setupMethod (){

    //  1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
@Test
public void nonSelectDropDown (){
    //2. Go to https://practice.cydeo.com/dropdown
   // 3. Click to non-select dropdown
    driver.get(" https://practice.cydeo.com/dropdown");
    WebElement nonSelectDropDown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
nonSelectDropDown.click();
//4. Select Facebook from dropdown
    WebElement facebookSelect = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
    facebookSelect.click();



    //5. Verify title is “”

   String actual = driver.getTitle();
   // System.out.println(actual);========> checking
String expected = "Facebook - Log In or Sign Up";
    Assert.assertEquals(actual,expected,"Not match");






}
    @AfterMethod
    public void tearDown (){
        driver.close();
    }

































}

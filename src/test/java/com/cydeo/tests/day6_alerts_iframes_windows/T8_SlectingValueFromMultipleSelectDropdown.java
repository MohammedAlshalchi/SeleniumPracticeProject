package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_SlectingValueFromMultipleSelectDropdown {
    /*
    TC #8: Selecting value from multiple select dropdown



     */
    WebDriver driver;
    @BeforeMethod
    public void setUpmethod (){

//        1. Open Chrome browser


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void dropSelection (){
       //2. Go to  https://practice.cydeo.com/dropdown
      // 3. Select all the options from multiple select dropdown.

      driver.get("https://practice.cydeo.com/dropdown");
        Select selctDropDownOption = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
selctDropDownOption.selectByVisibleText("JavaScript");
selctDropDownOption.selectByValue("java");
selctDropDownOption.selectByVisibleText("Ruby");
selctDropDownOption.selectByValue("c");
selctDropDownOption.selectByValue("c#");
selctDropDownOption.selectByIndex(3);


       // 4. Print out all selected values.

       // List <WebElement> elements = new ArrayList<>();
        List <WebElement> eachSelect = selctDropDownOption.getAllSelectedOptions();
        for (WebElement each: eachSelect ) {

            System.out.println(" each element selected "+each.getAttribute("text"));
        }


       // 5. Deselect all values.

       // selctDropDownOption.deselectAll();======> first way
        selctDropDownOption.deselectByVisibleText("JavaScript");
        selctDropDownOption.deselectByValue("java");
        selctDropDownOption.deselectByVisibleText("Ruby");
        selctDropDownOption.deselectByValue("c");
        selctDropDownOption.deselectByValue("c#");
        selctDropDownOption.deselectByIndex(3);
    }









@AfterMethod
    public void tearown (){
        driver.close();
}




































}

package com.cydeo.tests.day4_xpath_cssSelector_practice;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_DoiT {
    public static void main(String[] args) {
//        XPATH Practice
//        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
//        TC #6:  XPATH LOCATOR practice
//        1. Open Chrome browser
//        2. Go to http://practice.cydeo.com/multiple_buttons

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/multiple_buttons");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



//        3. Click on Button 1
        WebElement Button1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        Button1.click();



//        4. Verify text displayed is as expected:
        String expected ="Clicked on button one!";
WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
     String actual = message.getText();
        System.out.println(actual);

if (actual.equals(expected)){
    System.out.println("\"Passed\" = " + "Passed");
}else {
    System.out.println("\"FAILED!!!!!!!\" = " + "FAILED!!!!!!!");
}


//        Expected: “Clicked on button one!”
//
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

    }
}

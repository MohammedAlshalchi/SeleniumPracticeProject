package com.cydeo.tests.day4_xpath_cssSelector_practice;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {

//        TC #6: StaleElementReferenceException Task
//        1- Open a chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();



//        2- Go to: https://practice.cydeo.com/abtest
        //Providing extra wait time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/abtest");


//
//        3- Locate “CYDEO” link, verify it is displayed.

        WebElement cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println("cydeoLinkis disDisplay() = "+cydeoLink);



//        4- Refresh the page.
       driver.navigate().refresh();



//        5- Verify it is displayed, again.
        System.out.println("cydeoLinkis disDisplay() = "+cydeoLink);
//
//
//  This is a simple StaleElementReferenceException to understand what is
//        this exception and how to handle it.















    }
}

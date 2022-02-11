package com.cydeo.tests.day4_xpath_cssSelector_practice;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {
    public static void main(String[] args) {
//        TC #4: FindElements Task
//        1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();



//        2- Go to: https://practice.cydeo.com/abtest

        //Providing extra wait time for our driver before it throws NoSuchElementException
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://practice.cydeo.com/abtest");


//        3- Locate all the links in the page.
List<WebElement> allLink = driver.findElements(By.tagName("a"));
       // List<WebElement> elements = driver.findElements(By.tagName("a"));===> short cut


//        4- Print out the number of the links on the page.
        System.out.println("allLink.size() = " + allLink.size());


//        5- Print out the texts of the links.
//        6- Print out the HREF attribute values of the links

        for (WebElement each : allLink)
              {
                  System.out.println("Text of link "+ each);
                  System.out.println("Text of link "+ each.getText());
                  System.out.println("HREF Values: "+each.getAttribute("href"));

                  // EX: getAttribute(class) ===> will print what inside the ""
              }





















    }
}

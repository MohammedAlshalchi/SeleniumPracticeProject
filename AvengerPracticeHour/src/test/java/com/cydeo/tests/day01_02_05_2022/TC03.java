package com.cydeo.tests.day01_02_05_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC03 {
    public static void main(String[] args) {
         //Setup the "browser driver"
        //Go to "https://www.google.com"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");


        //Verify the title contains "Google"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test is Passed!");
        }else  System.out.println("Test Failed!");


        //Navigate to "https://www.etsy.com"
        driver.navigate().to("https://www.etsy.com");



        //Verify not in google page
       String Title = driver.getTitle();
        System.out.println(Title);

if ( (Title.contains("Google")) ){
    System.out.println("You are on Google page");
}else  System.out.println("Not in Google Page");





        //Verify the title  contains "Etsy"


String Title3 = driver.getTitle();

        if(Title3.contains("Etsy")){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");

    }

        driver.quit();
}}

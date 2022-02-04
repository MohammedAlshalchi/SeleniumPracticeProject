package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooVerification {
    public static void main(String[] args) {

   /*
   TC #1: Yahoo Title Verification
1.Open Chrome browser
   do setup for browser driver

2.Go to https://www.yahoo.com
3.Verify title:
Expected: Yahoo
    */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();




        driver.get("https://www.yahoo.com");
driver.manage().window().maximize();
String expectedTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos" ;



String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else{
            System.out.println("Title is NOT as expected. Verification FAILED!");
        }




































    }
}

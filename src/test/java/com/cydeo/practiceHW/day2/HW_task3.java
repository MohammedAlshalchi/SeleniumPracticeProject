package com.cydeo.practiceHW.day2;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW_task3 {
    public static void main(String[] args) {



//        TC #3: Back and forth navigation
//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


//        2- Go to: https://google.com
        driver.get("https://google.com");



//        3- Click to Gmail from top right.
WebElement Clickbuttom = driver.findElement(By.className("gb_d"));
Clickbuttom.click();




//        4- Verify title contains:
//        Expected: Gmail
String expectedTitle1 = driver.getTitle();
        System.out.println(expectedTitle1);
        if(expectedTitle1.contains("Gmail")){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

//        5- Go back to Google by using the .back();
        driver.navigate().back();


//        6- Verify title equals:
//        Expected: Google
       String expectedTitle2 = driver.getTitle();
        System.out.println(expectedTitle2);
if (expectedTitle2.equals( "Google")){
    System.out.println("Passed!");
}else{
    System.out.println("Failed!");
}





















    }
}

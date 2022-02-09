package com.cydeo.practiceHW.day2;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW_task4 {
    public static void main(String[] args) {
//        TC #4: Practice Cydeo – Class locator practice
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/inputs
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/inputs");



//        3- Click to “Home” link
        WebElement homeButtom = driver.findElement(By.className("nav-link"));
        homeButtom.click();




//        4- Verify title is as expected:
//        Expected: Practice
        String expected = "Practice";
       String actual = driver.getTitle();
        if(actual.equals(expected)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

        driver.quit();

//
//        PS: Locate “Home” link using “className” locator





















    }
}

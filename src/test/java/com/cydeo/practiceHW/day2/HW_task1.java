package com.cydeo.practiceHW.day2;

import com.cydeo.utilites.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_task1 {
    public static void main(String[] args) {

//        TC #1: Etsy Title Verification
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
//        2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");


//        3. Search for “wooden spoon”
      WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
searchBar.sendKeys("wooden spoon"+Keys.ENTER);
//searchBar.submit();



//        4. Verify title:
//        Expected: “Wooden spoon | Etsy”
String actualTitle = driver.getTitle();
        System.out.println(actualTitle);// JUST TO CHECK

String expectedTitle = "Wooden spoon | Etsy";


if (actualTitle.equals(expectedTitle)){
    System.out.println("PASSED");
}else {
    System.out.println("FAILED!!!!!!");
}

driver.quit();




    }
}

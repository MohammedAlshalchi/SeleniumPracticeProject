package com.cydeo.practiceHW.day2;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HW_task2 {
    public static void main(String[] args) {


//        TC #2: Zero Bank header verification
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


//        2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");



//        3. Verify header text
String actualHeader = driver.findElement(By.tagName("h3")).getText();
        System.out.println(actualHeader);
String expextedHeader = "Log in to ZeroBank";

//        Expected: “Log in to ZeroBank”


if (actualHeader.equals(expextedHeader)){
    System.out.println("PASSED");
}else {
    System.out.println("FAILED!!!!!!");
}


driver.quit();



    }
}

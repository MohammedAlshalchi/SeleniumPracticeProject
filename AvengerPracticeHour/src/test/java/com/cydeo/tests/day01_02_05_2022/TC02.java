package com.cydeo.tests.day01_02_05_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC02 {
    public static void main(String[] args) {
//Setup the "browser driver"

        //Go to "https://www.selenium.dev"

        //Verify the title contains "Selenium"


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev");

        String expected = "Selenium";
        String actual = driver.getTitle();


        if (expected.contains(actual)) {
            System.out.println("PASSED");
        } else {
            System.err.println("FAILED");


        }
        driver.quit();

    }
}
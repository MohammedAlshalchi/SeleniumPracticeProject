package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {


    public static void main(String[] args) {
        //1. set up chrome driver
        // we create our "Browser Driver"
        WebDriverManager.chromedriver().setup();// come from bonigarcia
        // 2. create webDriver instance that point to chrome driver
        WebDriver driver = new ChromeDriver();
        // open new empty browser
        //3. Navigate to https://google.com
        driver.navigate().to("http://google.com");// our selenium method

    }


}

package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

        // TASK: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chrome browser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"

public static WebDriver  getDriver (String browserType){

    if (browserType.equalsIgnoreCase("chrome")){
        //System.out.println("PAsSED browser is chrome");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }else if (browserType.equalsIgnoreCase("firefox")){
        //System.out.println("\"PASSED browser is firefox\" = " + "PASSED browser is firefox");
        WebDriverManager.firefoxdriver().setup();
        return new  FirefoxDriver();

    }else {
        System.out.println("\"FAILED no such browser\" = " + "FAILED no such browser");
    }

   return null;


}














}

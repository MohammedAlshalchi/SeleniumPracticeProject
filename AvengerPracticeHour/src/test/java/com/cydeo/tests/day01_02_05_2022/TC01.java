package com.cydeo.tests.day01_02_05_2022;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
    public static void main(String[] args) {

        //Setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Go to "https://www.selenium.dev"
        driver.get("https://www.selenium.dev");
        //Verify the URL
        String expectedURL="https://www.selenium.dev/";
        String actualURL=driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }
















    }
}

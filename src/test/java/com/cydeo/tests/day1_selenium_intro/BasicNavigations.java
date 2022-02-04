package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1- Set up the 'BROWSER DRIVER"
        WebDriverManager.chromedriver().setup();
        //2- This is the line opening an empty browser
        WebDriver driver =new ChromeDriver();


//This line will maximize the browser size
        driver.manage().window().maximize();
driver.manage().window().maximize();

        //3- Go to "https://www.tesla.com
        driver.get("https://www.tesla.com");
        //get the title of the page

        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("CurrentULR = "+currentURL);

        Thread.sleep(3000);
        // use selenium to navigate back
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        // use selenium to navigate refresh
        driver.navigate().refresh();
        Thread.sleep(3000);
        // use navigate().to ====> come from Java
        driver.navigate().to("https://www.google.com");
        currentTitle = driver.getTitle();

        //System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("currentTitle = " + currentTitle);
        Thread.sleep(3000);
        // GET THE TITLE of the page
       // System.out.println("currentTitle = " + currentTitle);//use the web title just before it

        //Get the current ULR using Selenium
         currentURL = driver.getCurrentUrl();
        System.out.println("CurrentULR = "+currentURL);
        // this will close the currently opened window
        driver.close();

        // this will close all the windows
        driver.quit();

    }
}

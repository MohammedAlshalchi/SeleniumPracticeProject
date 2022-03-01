package com.cydeo.tests.day6_alerts_iframes_windows;


import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_Windoes_Practice {




//7. Assert: Title is “New Window”

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
//    TC #5: Window Handle practice
//1. Create a new class called: T5_WindowsPractice
//2. Create new test and make set ups
//3. Go to : https://practice.cydeo.com/windows
            driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");


    }
@Test
   public void multiple_window_test () {
     //Storing the main page's window handle as string is
    // good practice for future re-usable purposes
  String mainHandle = driver.getWindowHandle();
    System.out.println("\"MainHQANDE = \"+mainHandle = " + "MainHQANDE = " + mainHandle);



//            4. Assert: Title is “Windows”
    String expectedTitle = "Windows";
String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle,expectedTitle);
    System.out.println("Title before click:" + actualTitle);




//            5. Click to: “Click Here” link
    WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
    clickHereLink.click();
    actualTitle =driver.getTitle();
    System.out.println("Title after click: " + actualTitle);


//6. Switch to new Window.
    //Set<String> allWindowHandles = driver.getWindowHandles();===> we can use now but mainly we use it if we have
    // more than 2 windows
    // window handle 1 - main window
    // window handle 2 - 2nd window

    for (String each: driver.getWindowHandles() ) {// will bring all opened windows

       driver.switchTo().window(each) ;
        System.out.println("Current title while switching windows: "+driver.getTitle());
    }

    //7. Assert: Title is “New Window”

  String  expectedTitleAfterClick =  "New Window";
  actualTitle = driver.getTitle();


  Assert.assertEquals(actualTitle,expectedTitleAfterClick);
    System.out.println("Title after click: " + actualTitle);


    //If we want to go back to main page, we can use already stored main handle
    //driver.switchTo().window(mainHandle);
}

//@AfterMethod
//    public void tearDown (){
//        driver.quit(); /// we use quit NOT close because we have more than one window
//}







}

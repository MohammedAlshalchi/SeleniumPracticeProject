package com.cydeo.tests.day01_02_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04 {
    private static WebDriver driver;


    public static void main(String[] args) {



        //- Go to "https://app.vytrack.com/user/login"
        forEachVerification ("https://app.vytrack.com/user/login");


        //- Verify the url contains "vytrack"
verifingURLContains("vytrack");


        //- Verify the title contains "Login"

        verifingTitleContains("Login");



        //- Verify the label "Login"
        verfifyingLabel("Login");

        //login
login("abcd","abcd");




//- Verify the message "Invalid user name or password"
        verifyingMessage("Invalid user name or password.");




driver.quit();
}




    private static void verifyingMessage(String expectedMessage) {
        WebElement messageElement = driver.findElement(By.className("alert"));
        String actualMessage = messageElement.getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Message is PASSED");
        }else {
            System.err.println("Message is FAILED");
        }
    }



    private static void login(String username, String password) {
        WebElement usernmeWebElement = driver.findElement(By.name("_usernme"));
usernmeWebElement.sendKeys(username);
WebElement passwordWebElement = driver.findElement(By.id("prependedInput2"));
passwordWebElement.sendKeys(password);
// click button
driver.findElement(By.id("_submit")).click();
    }



    private static void verfifyingLabel(String expectedLabelText) {
        WebElement labelElement = driver.findElement(By.tagName("h2"));
        String actualLabelTexttext = labelElement.getText();
        if (actualLabelTexttext.equals(expectedLabelText)){
            System.out.println("Label is PASSED");
        }else{
            System.err.println("Label is FAILED");
        }
    }



    private static void verifingTitleContains(String expectedWord) {
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedWord)){
            System.out.println("Tilte is PASSED");
        }else {
            System.err.println("Tilte  is FAILED");
        }


    }


    private static void verifingURLContains(String expectedWord) {

        String actualURL  = driver.getCurrentUrl();

        if (actualURL.contains(expectedWord)){
            System.out.println("Message is PASSED");
        }else {
            System.err.println("Message is FAILED");
        }
    }



    private static void forEachVerification(String url) {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }







}

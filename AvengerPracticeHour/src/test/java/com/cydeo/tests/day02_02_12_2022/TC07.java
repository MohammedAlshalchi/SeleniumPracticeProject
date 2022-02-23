package com.cydeo.tests.day02_02_12_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC07 {
    public static void main(String[] args) {
        // TC:7 As a user I should be able to see User is John Doe

        //1-open a chrome browser
        //2-goto https://vytrack.com/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://vytrack.com/");




        //3-click Login label
        WebElement loginLable = driver.findElement(By.cssSelector("#top-menu>li#menu-item-849>a"));
loginLable.click();

        //4-enter username "User1"
        driver.findElement(By.name("_username")).sendKeys("User1");



       // 5-enter password "UserUser123"
        driver.findElement(By.name("_password")).sendKeys("UserUser123");



        //6-click LOG IN
        //driver.findElement(By.id("_submit")).click();
driver.findElement(By.xpath("//button[@id='_submit']")).click();


        //7-verify the user John Doe
        WebElement loginwebElement = driver.findElement(By.xpath("//ul[@class='nav pull-right user-menu']/li[4]/a"));
        String actualText = loginwebElement.getText();
String expectedText = "John Doe";
if (actualText.equals(expectedText)){
    System.out.println("\"PASSED!!!!\" = " + "PASSED!!!!");
}else System.out.println("\"Failed\" = " + "Failed");

driver.quit();
    }
}

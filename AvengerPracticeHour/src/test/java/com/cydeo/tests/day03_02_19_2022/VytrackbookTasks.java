package com.cydeo.tests.day03_02_19_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackbookTasks {
/*
TC 1- As a user I should be able to see the labels [“Home”,”About us”,”Our
Approach”,”Products and Services”,”Contact”,”LOGIN”]
1- Open a chrome browser


 */

    WebDriver driver;

@BeforeMethod
    public void setUp (){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




}


@Test
    public void TC01_verifying_header_labels() {

    //2- Go to “https://vytrack.com/”
    driver.get("https://vytrack.com/");
//TC 1- As a user I should be able to see the labels [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,”LOGIN”]

    List<WebElement>listOfHeaderWebElements= driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));


//first solution
       /* for (WebElement headerWebElement : listOfHeaderWebElements) {
            Assert.assertTrue(headerWebElement.isDisplayed());
        }
        */

//second solution

List<String> expectedHeaderLabels= new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));
/*
    for (WebElement headerWebElement:listOfHeaderWebElements ) {
        Assert.assertTrue(expectedHeaderLabels.contains(headerWebElement.getText()));
        
    }
*/

    List<String> actualHeaderLabels=new ArrayList<>();
    for (WebElement headerWebElement : listOfHeaderWebElements) {
        actualHeaderLabels.add(headerWebElement.getText());
    }
    Assert.assertEquals(actualHeaderLabels, expectedHeaderLabels);



    //3- Verify that [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,”
    //LOGIN”] is displayed



}

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//
//    Thread.sleep(3000);
//    driver.close();
//    }
}

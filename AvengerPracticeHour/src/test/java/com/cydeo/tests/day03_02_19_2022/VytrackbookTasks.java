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
    //2- Go to “https://vytrack.com/”
    driver.get("https://vytrack.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




}


@Test
    public void TC01_verifying_header_labels() {


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

    @Test
    public void TC2_verify_labels_under_our_approach() throws InterruptedException {

        //TC 2- As a user I should be able to see the labels ["Our Mission and Vision","Car Fleet Management",
        // "Newest Technologies","Tailor Made Solutions"] under Our Approach
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@id='top-menu']/li[3]/a")).click();
        Thread.sleep(3000);
        List<WebElement> webElementList = driver.findElements(By.xpath("//ul[@id='top-menu']/li[3]/ul/li/a"));
        List<String > actualTextsOfWebElements=new ArrayList<>();

        for (WebElement element : webElementList) {
            actualTextsOfWebElements.add(element.getText());
        }
        List<String> expectedTextsOfWebElements=new ArrayList<>(Arrays.asList("Our Mission and Vision","Car Fleet Management",
                "Newest Technologies","Tailor Made Solutions"));

        Assert.assertEquals(actualTextsOfWebElements, expectedTextsOfWebElements);
        //3- Verify that ["Our Mission and Vision","Car Fleet Management","Newest Technologies","Tailor Made Solutions"] is displayed
    }

    @Test
    public void TC3_verify_the_fleet_analysis_and_optimizasyon_page() throws InterruptedException {
        //TC 3 - As a user I should be able to see Fleet Analysis and Optimization Page

        // 3- Click Products and Services
        driver.findElement(By.xpath("(//ul[@id='top-menu'])/li[4]")).click();
        Thread.sleep(3000);
        //4- Click Fleet analysis and optimization
        driver.findElement(By.xpath("(//ul[@id='top-menu'])/li[4]/ul/li/a[.='Fleet analysis and optimization']")).click();
        //5- Verify the page and label
        String expectedWordInURL="fleet-analysis-and-optimization";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedWordInURL));

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {

    Thread.sleep(3000);
    driver.close();
    }
}

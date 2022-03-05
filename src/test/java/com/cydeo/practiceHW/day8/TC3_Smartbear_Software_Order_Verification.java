package com.cydeo.practiceHW.day8;

import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.SmartBearUtils;
import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_Smartbear_Software_Order_Verification {
    /*
    TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”
     */

public WebDriver driver;
@BeforeMethod
    public void setup() {
    String browserType = ConfigurationReader.getProperty("browser");
    driver = WebDriverFactory.getDriver(browserType);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(ConfigurationReader.getProperty("env1"));
    SmartBearUtils.loginToSmartBear(driver);

}
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void orderVerification(){
        WebElement viewAllOrdersLink = driver.findElement(By.xpath("//table//tbody//a[.='View all orders']"));
        viewAllOrdersLink.click();


        // WebElement orderDateOfSuSanMcLaren = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']
        // tbody//td[.='Susan McLaren']/../td[5]")); or
       WebElement orderDateOfSuSanMcLaren = driver.findElement(By.xpath("" +
                       "//table[@id='ctl00_MainContent_orderGrid']//tbody//td[.='Susan McLaren']/following-sibling::td[3]"));


        String actualOrderDate = orderDateOfSuSanMcLaren.getText();
        String expectedOrderDate =  "01/05/2010";

        Assert.assertEquals(expectedOrderDate,actualOrderDate);


    }



    }









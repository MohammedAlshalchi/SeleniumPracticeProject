package com.cydeo.practiceHW.day8;

import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task_GasMileage {
    /*
    Task #: Gas Mileage Calculator Automation Test

1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed
6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg”
     */

  public WebDriver driver;

    @BeforeMethod
    public void setUp (){
    String browserType = ConfigurationReader.getProperty("browser");
    driver = WebDriverFactory.getDriver(browserType);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(ConfigurationReader.getProperty("env3"));

    }


    @Test
    public void GasMileageCalculatorTest (){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement gasMileageCalcualator = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageCalcualator.click();

        String actual = driver.getTitle();
        String expected ="Gas Mileage Calculator";
        Assert.assertEquals(actual,expected);
        WebElement displayGasMileageCal = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']"));
        Assert.assertTrue(displayGasMileageCal.isDisplayed(),
                "Gas Mileage Calculator is not displayed after clicking");

        WebElement currentOdometer = driver.findElement(By.xpath("//input[@id='uscodreading']"));
currentOdometer.clear();
currentOdometer.sendKeys("7925");

WebElement previousOdometer = driver.findElement(By.xpath("//input[@id='uspodreading']"));
previousOdometer.clear();
previousOdometer.sendKeys("7550");


WebElement gasAdded = driver.findElement(By.xpath("//input[@id='usgasputin']"));
gasAdded.clear();
gasAdded.sendKeys("16");

WebElement gasPrice = driver.findElement(By.xpath("//input[@id='usgasprice']"));
gasPrice.clear();
gasPrice.sendKeys("3.55");


WebElement calculatorButton = driver.findElement(By.xpath("(//input[@value='Calculate'])[1]"));
calculatorButton.click();




WebElement result = driver.findElement(By.xpath("//b[.='23.44 mpg']"));
String actualResult = result.getText();
String expectedResult = "23.44 mpg";
Assert.assertEquals(actualResult,expectedResult);


    }



@AfterMethod
    public void tearDown (){
        driver.quit();
}










































}

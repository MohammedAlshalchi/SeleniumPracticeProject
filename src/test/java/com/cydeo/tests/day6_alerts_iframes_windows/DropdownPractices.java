package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
   public WebDriver driver;

    @BeforeMethod
    public void setupMethod (){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/dropdown");

    }




@Test
        public void dropdown_task5() throws InterruptedException {
//    TC #5: Selecting state from State dropdown and verifying result



//we located the dropdown and it is ready to use
 Select   stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));


//3. Select Illinois
    Thread.sleep(1000);
stateDropdown.selectByVisibleText("Illinois");


//4. Select Virginia
    Thread.sleep(1000);
stateDropdown.selectByValue("VA");


//5. Select California
  Thread.sleep(1000);
  stateDropdown.selectByIndex(5);


//6. Verify final selected option is California.
    String expectedOptionText = "California";
String actualOptionText = stateDropdown.getFirstSelectedOption().getText();
    Assert.assertEquals(actualOptionText,expectedOptionText);
//    Use all Select options. (visible text, value, index)

}



//    TC #6: Selecting date on dropdown and verifying
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//            3. Select “December 1st, 1923” and verify it is selected.
//    Select year using  : visible text
//    Select month using   : value attribute
//    Select day using : index number




@Test
    public void dropdown_task6 (){

//    TC #6: Selecting date on dropdown and verifying
//    3. Select “December 1st, 1923” and verify it is selected.
    Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
    Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
    Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


//    Select year using  : visible text
yearDropdown.selectByVisibleText("1923");

//    Select month using   : value attribute
monthDropdown.selectByValue("11");

//    Select day using : index number
dayDropdown.selectByIndex(0);

    //creating expected values
    String expectedYear = "1923";
    String expectedMonth= "December";
    String expectedDay = "1";

    //getting actual values from browser

    String actualYear = yearDropdown.getFirstSelectedOption().getText();
    // we can not store webElement in String
    String actualMonth = monthDropdown.getFirstSelectedOption().getText();
    String actualDay = dayDropdown.getFirstSelectedOption().getText();


    //create assertions
    Assert.assertEquals(actualYear,expectedYear);
    Assert.assertEquals(actualMonth,expectedMonth);
    Assert.assertEquals(actualDay,expectedDay);



}

@AfterMethod
    public void tearDown  (){
    driver.close();
}


}

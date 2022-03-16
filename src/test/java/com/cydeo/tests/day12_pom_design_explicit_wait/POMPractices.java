package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginage;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

LibraryLoginage libraryLoginage;

@BeforeMethod
public void setupMethod (){
    Driver.getDriver().get("https://library1.cydeo.com/");
    libraryLoginage = new LibraryLoginage();

}
    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginage.fieldRequiredErrorMessage.isDisplayed());
        Driver.getDriver().quit();
    }


    @Test
    public void   Invalid_email_format_error_message_test(){
//        TC #2: Invalid email format error message test
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com/
//        3- Enter invalid email format
       libraryLoginage.inputUsername.sendKeys("somethingwrong");
        libraryLoginage.signInButton.click();
//        4- Verify expected error is displayed:
//        Expected: Please enter a valid email address.
         Assert.assertEquals(libraryLoginage.enterValidEmailErrorMessage.getText(),
        "Please enter a valid email address.");
        Assert.assertTrue(libraryLoginage.enterValidEmailErrorMessage.isDisplayed());
//        NOTE: FOLLOW POM DESIGN PATTERN
        Driver.getDriver().quit();

    }


    @Test
    public void  library_negative_login(){
//        TC #3: Library negative login
//        1- Open a Chrome browser
//        2- Go to: https://library1.cydeo.com/
//        3- Enter incorrect username or incorrect password
        libraryLoginage.inputUsername.sendKeys("wrong@username.com");
        libraryLoginage.inputPassword.sendKeys("wrongpassword");
        libraryLoginage.signInButton.click();

//        4- Verify title expected error is displayed:
//        Expected: Sorry, Wrong Email or Password
Assert.assertEquals(libraryLoginage.wrongEmailOrPasswordErrorMessage.getText(),
        "Sorry, Wrong Email or Password");
        Assert.assertTrue(libraryLoginage.wrongEmailOrPasswordErrorMessage.isDisplayed());
//        NOTE: FOLLOW POM DESIGN PATTERN

Driver.getDriver().quit();
    }


}

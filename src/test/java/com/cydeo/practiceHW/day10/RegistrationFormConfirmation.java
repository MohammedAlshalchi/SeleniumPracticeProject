package com.cydeo.practiceHW.day10;

import com.cydeo.utilites.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormConfirmation {
    /*
    TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.

Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
     */

    @Test
    public void  Registration_form_confirmation(){

        Driver.getDriver().get("https://practice.cydeo.com/registration_form");
        Faker faker =new Faker();


        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

      WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
      lastName.sendKeys(faker.name().lastName());

      WebElement username =Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
      username.sendKeys(faker.bothify("aabb1122hh"));

      WebElement emailAdress = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
      emailAdress.sendKeys(faker.internet().emailAddress());

      WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
      password.sendKeys(faker.internet().password());


      WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
      phoneNumber.sendKeys(faker.numerify("###-###-####"));

      WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@name='gender']"));
      gender.click();

      WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
      dateOfBirth.sendKeys(faker.numerify("06/06/1978"));

        Select department= new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        department.selectByIndex(2);

        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(5);


        Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();


        Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']")).click();

      WebElement bottun =  Driver.getDriver().findElement(By.xpath("//p"));
       String actual = bottun.getText();
       String expected = "You've successfully completed registration!";
        Assert.assertEquals(actual,expected);
        // Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//p")).getText(),"You've successfully completed registration!");
       // Assert.assertTrue(bottun.isDisplayed());






  //OTHER SOLUTION
/*
public class RegistrationformConfirmation  extends TestBase {

  @Test
      public void registrationForm() {

      driver.get("https://practice.cydeo.com/registration_form");


        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lname = faker.name().lastName();
        String uname = faker.letterify("??????");
        String email = faker.internet().emailAddress();
        String pword = faker.letterify("??????????");
        String pnum = faker.numerify("###-###-####");


        String birthday = ("02/07/1979");

        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipcode = faker.address().zipCode();

        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys(name);

        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys(lname);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(uname);

        WebElement emailadress = driver.findElement(By.xpath("//input[@name='email']"));
        emailadress.sendKeys(email);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(pword);

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(pnum);
        WebElement gender = driver.findElement(By.xpath("//div[@class='radio']//input[@value='male']"));
        gender.click();
        WebElement bday = driver.findElement(By.xpath("//input[@name='birthday']"));
        bday.sendKeys(birthday);


        Select departselect = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departselect.selectByIndex(2);

        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(4);

        List<WebElement> lanselct = driver.findElements(By.xpath("(//div[@class='col-sm-5'])[11]"));

        for (WebElement each : lanselct) {
            System.out.println();
            each.getText();
            each.click();
        }

        WebElement language1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        WebElement language2 = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        WebElement language3 = driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));

        language1.click();
        language2.click();
        language3.click();

        WebElement submit = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        submit.click();

        WebElement welldone = driver.findElement(By.xpath("//p"));
        System.out.println("IS DISPLAYED " + welldone.isDisplayed());
    }
    }

```
 */



















    }








}

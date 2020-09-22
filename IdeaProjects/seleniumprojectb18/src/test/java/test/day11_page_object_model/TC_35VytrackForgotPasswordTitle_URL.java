package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC_35VytrackForgotPasswordTitle_URL {

    LoginPage loginPage;

   @Test
    public void Title_URL(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

       WebElement forgotPasswordButton= Driver.getDriver().findElement(By.xpath("//a[@href='/user/reset-request']"));
        forgotPasswordButton.click();

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

       Assert.assertEquals(actualTitle,expectedTitle);

       String actualUrl = Driver.getDriver().getCurrentUrl();
       String expectedUrl = "https://qa3.vytrack.com/user/reset-request";

        Assert.assertEquals(actualUrl,expectedUrl);

   }
   @Test
   public void forgotPasswordpageVerification(){

       LoginPage loginPage;

       Driver.getDriver().get(ConfigurationReader.getProperty("url"));

       loginPage =new LoginPage();

       WebElement input = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
       input.sendKeys("kjkdj");

       WebElement requestButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
       requestButton.click();

       Assert.assertTrue(loginPage.errorMessage.isDisplayed());

       String excepted =loginPage.errorMessage.getText();
       String actual = "There is no active user with username or email address"+loginPage.errorMessage;






   }






}

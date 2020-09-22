package test.day12_synchonization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordpage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ForgotPasswordsTests {

    //1. Go to https://qa3.vytrack.com
    //2. Click to "Forgot your password?" link
    //3. Verify title changed to expected
    //    Expected: "Forgot Password"
    //4. Verify url is as expected:
    //    Expected: "https://qa3.vytrack.com/user/reset-request"
    //   Note: Follow Page Object Model design patter

    @Test
    public void tc35_title_url_verification(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage=new LoginPage();
        loginPage.forgotPasswordLink.click();

        //3. Verify title changed to expected
        String expectedTitle = "Forgot Password";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        //4 Verify URL is as expected

        String expectedURL = "https://qa2.vytrack.com/user/reset-request";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void tc35_error_message_verification2(){

        Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));

        ForgotPasswordpage forgotPasswordpage =new ForgotPasswordpage();

        String randomString= "asdfaa";

        //sending a random string into input box
        forgotPasswordpage.inputBox.sendKeys(randomString);

        //clickin to request button

        forgotPasswordpage.requestButton.click();

        //verify error messahe is displayed
        Assert.assertTrue(forgotPasswordpage.errorMessage.isDisplayed());

        //verify that error message text value is expected and contains random string
        String expectedmessage = "There is no active user with username or email address \""+randomString+"\".";
        String actualMessage =forgotPasswordpage.errorMessage.getText();

        Assert.assertEquals(actualMessage,expectedmessage);

    }

}

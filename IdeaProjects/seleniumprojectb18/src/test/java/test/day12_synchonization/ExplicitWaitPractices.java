package test.day12_synchonization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {

   //TC#40: Dynamically Loaded Page Elements 7
    // 1.Go tohttp://practice.cybertekschool.com/dynamic_loading/7
    // 2.Wait until title is “Dynamic Title”
    // 3.Assert : Message “Done” is displayed.
    // 4.Assert : Image is displayed.
    // Note: Follow POM

    @Test
    public void tc40_dynamic_title_test(){

       String url ="http://practice.cybertekschool.com/dynamic_loading/7" ;
        Driver.getDriver().get(url);

        Loading7Page loading7Page = new Loading7Page();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());

        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());

    }

    /*
    TC#41: Dynamically Loaded Page Elements 1
1.Go to http://practice.cybertekschool.com/dynamic_loading/1
2.Click to start
3.Wait until loading bar disappears
4.Assert username inputboxis displayed
5.Enter username: tomsmith
6.Enter password: incorrectpassword
7.Click to Submit button
8.Assert "Your username is invalid!" text is displayed.
     */


    @Test
    public void
    tc41_dynamic_form_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1page loading1page = new Loading1page();

        loading1page.startButton.click();

        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.invisibilityOf(loading1page.loadingBar));

        Assert.assertTrue(loading1page.usernameInput.isDisplayed());

        loading1page.usernameInput.sendKeys("tomsmith");
        loading1page.passwordInput.sendKeys("asdfasdf");
        loading1page.submitButton.click();

        Assert.assertTrue(loading1page.errorMessage.isDisplayed());

    }

}

package test.vyTrackPractice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.test_Office.ConfigReaderPractice;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class VerificationTests {

    @BeforeMethod
    public void access_login_to_page(){

        Driver.getDriver().get("http://vytrack.com");

       // Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tear_down() throws Exception{
        //Thread.sleep(1000);
       // Driver.getDriver().close();
       // Driver.getDriver().quit();
    }
    //Authorized users should be able to login and enter their credentials
    @Test
    public void test() throws Exception {

        //Authorized user  should be able to access to the login page
        Driver.getDriver().findElement(By.xpath("//a[.='LOGIN']")).click();
        //login ,enter credentials
        Thread.sleep(2000);
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        usernameBox.sendKeys(ConfigReaderPractice.getProperty("username"));

        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        passwordBox.sendKeys(ConfigReaderPractice.getProperty("password") + Keys.ENTER);

        // 1.Authorized user should be able to access vehicle contract

        //hover over FLEET
        Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        actions.moveToElement(fleet).build().perform();
        Thread.sleep(2000);
        //choose Vehicle Contracts and click
        WebElement fleet1 = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        fleet1.click();
        //now authorized users can see the vehicle contracts on the grid

        //2. Authorized user should be able to create a contract
        Thread.sleep(2000);


        WebElement createContractButton = Driver.getDriver().findElement(By.xpath("//a[@title='Create Vehicle Contract']"));
        createContractButton.click();
        Thread.sleep(2000);
    }
            @Test
            public void contract()throws Exception{

           Select dropDownType = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='custom_entity_type_Type-uid-5f03c8a8665e3']")));
             Thread.sleep(2000);
           dropDownType.selectByVisibleText("Cash");


       }



}

package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTests {

    LoginPage loginPage;

    @Test
    public void store_manager_login_Test()throws  Exception{

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        loginPage=new LoginPage();

        String username = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username,password);

        String expectedTitle = "Dashboard";

        Thread.sleep(2000);
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

}

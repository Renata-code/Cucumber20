package test.test_Office;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DataProviderExample {

    @Test
    public void loginTest() throws InterruptedException{
        WebDriver driver = Driver.getDriver();
        driver.get("https://qa1.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Dashboard");
        driver.quit();
    }

}

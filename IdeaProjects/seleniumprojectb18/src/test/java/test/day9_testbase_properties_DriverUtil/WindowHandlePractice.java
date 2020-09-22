package test.day9_testbase_properties_DriverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice extends TestBase {


    @Test
    public void multiple_window_test(){

        driver.get("https://www.amazon.com");
          //downcasting our driver to JavaScript executer
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //create a logic to switch to the tab where Etsy.com is open

        Set<String> windowHandles =  driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("current title "+ driver.getTitle());

            if(driver.getCurrentUrl().contains("etsy")){
                //Assert: Title contains "Etsy"
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }
    }
}

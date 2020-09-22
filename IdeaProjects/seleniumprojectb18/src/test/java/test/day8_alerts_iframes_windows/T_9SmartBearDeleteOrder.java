package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T_9SmartBearDeleteOrder {

    WebDriver driver;

    @BeforeMethod
    public void set_up() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }


    @Test
    public void DeleteNmae() throws Exception{
          //locating Mark Smith checkbox button using
        WebElement MaksSmithCheckbox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        //clicking to the checkbox
        MaksSmithCheckbox.click();
        Thread.sleep(2000);

        //locating the delete button
        WebElement DeleteButton = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnDelete\"]"));
        DeleteButton.click();

        List<WebElement>names = driver.findElements(By.xpath("/*[@id=\"ctl00_MainContent_orderGrid\"]//tr/td[2]"));

        for(WebElement name: names ){
            Assert.assertFalse(name.getText().equals("Mark Smith"));
        }








    }

}

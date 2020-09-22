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

public class T10SmartBearEditOrder {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);

    }
    @Test
    public void EditButton () {
        WebElement EditButtonSteveJohns = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]//tr[4]/td[13]/input"));
        EditButtonSteveJohns.click();

        WebElement textWithSteveJohnsName = driver.findElement(By.xpath("//input[@value ='Steve Johns']"));
        textWithSteveJohnsName.clear();
        textWithSteveJohnsName.sendKeys("Michael Jordan");
        WebElement updateButton = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]"));
        updateButton.click();

        List<WebElement>names = driver.findElements(By.xpath("//table[@class = 'SampleTable']//tr/td[2]"));

        for (WebElement name : names) {
            if(name.getText().equals("Michael Jordan")) {
                Assert.assertTrue(name.getText().equals("Michael Jordan"));
            }
        }
        }


    public void removeName(WebDriver driver,String nameToBeDeleted){

        String xpathforCheckboxes = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='"+nameToBeDeleted+"']/../td[1]";

       // WebElement dynamicCheckBox = driver.findElement(By.xpath(""))










    }

}

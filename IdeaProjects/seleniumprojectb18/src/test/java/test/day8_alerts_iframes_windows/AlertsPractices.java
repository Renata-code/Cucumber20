package test.day8_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

    //TC #1: Information alert practice1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Alert”button
    // 4.Click to OK button from the alert
    // 5.Verify “You successfulyclicked an alert”text is displayed.

    // TC #2: Confirmationalert practice1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Confirm” button
    // 4.Click to OK button from the alert
    // 5.Verify “You clicked: Ok” text is displayed.
    // TC #3: Information alert practice1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts3.Click to “Click for JS Prompt” button
    // 4.Send “hello”text to alert
    // 5.Click to OK button from the alert
    // 6.Verify “You entered:  hello” text is displayed.

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void p1_information_alert_test() {
        // 3.Click to “Click for JS Alert”button
        // 4.Click to OK button from the alert

        WebElement infoAlertButton = driver.findElement(By.xpath("//button[@class = 'btn btn-primary']"));

        infoAlertButton.click();

        //Create an Alert instance and switch to it

        Alert alert = driver.switchTo().alert();

        //2 Use "alert: to accept alert

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed());
    }

    @Test
    public void p2_confirmation_alert_test() throws Exception {

        WebElement confirmationAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        confirmationAlert.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        alert.dismiss();

        //locating result web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

           //asserting the text is displayed
        Assert.assertTrue(resultText.isDisplayed());


    }
    @Test
    public void p3_Information_alert() throws Exception{

        WebElement informationAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']")) ;
       //java script alerts are not part of the html structure
        informationAlert.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();


    }
}
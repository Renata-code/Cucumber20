package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SelectTask3 {

    //December 1st,1921 select by visible text,index,,value attribute

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
    @Test
    public void task3_select_date_test(){
        Select yeardropdown = new Select (driver.findElement(By.xpath("//select[@id='year']")));
        yeardropdown.selectByVisibleText("1921");

        String yearActual = yeardropdown.getFirstSelectedOption().getText();
        String excepectedYear = "1921";

        Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthdropdown.selectByValue("11");

        String monthActual = monthdropdown.getFirstSelectedOption().getText();
        String expectedMonth = "December";

        Select daydropdown = new Select (driver.findElement(By.xpath("//select[@id='day']")));
        daydropdown.selectByIndex(0);

        String dayActual = daydropdown.getFirstSelectedOption().getText();
        String dayExcpected = "1";

        Assert.assertEquals(yearActual,excepectedYear);
        Assert.assertEquals(monthActual,expectedMonth);
        Assert.assertTrue(dayActual.equals(dayExcpected));
    }
}

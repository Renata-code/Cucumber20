package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class CybertekRegistration {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
      driver.close();
      driver.quit();

    }

    @Test
    public void registration ()throws Exception{

        Faker faker = new Faker();
        Thread.sleep(2000);
        //faker.name().firstName();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("abcd1234");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("email@email.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234abcd");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("571-000-0000");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//input[@name = 'birthday']")).sendKeys("03/26/2000");
        driver.findElement((By.xpath("//select[@name = 'department']"))).click();
        driver.findElement(By.xpath("//option[@value = 'DE']")).click();
        driver.findElement(By.xpath("//select[@name='job_title']")).click();
        driver.findElement(By.xpath("//option[.='SDET']")).click();
        driver.findElement(By.xpath("//input[@value ='java']")).click();
        driver.findElement(By.xpath("//button[@type ='submit']")).click();

        String actualmesage = "You've successfully completed registration!";
        String expectedMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p")).getText();

        Assert.assertEquals(actualmesage,expectedMessage);









    }

}

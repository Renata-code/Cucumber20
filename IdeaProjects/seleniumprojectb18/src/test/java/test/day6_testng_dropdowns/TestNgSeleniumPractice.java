package test.day6_testng_dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TestNgSeleniumPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //goal is to open a new browser for each test.
        //what annotation i should be using for this
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown()throws Exception{
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Test(priority = 2)
    public void google_title_test(){
      //go to google

         driver = WebDriverFactory.getDriver("chrome") ;

        driver.get("https://www.google.com");
        //verify title :Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        //the line where we do assertion
        // returns boolean
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        //here 2 arguments of the same type(assert.equals)
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Test(priority = 1)
    public void google_title_verification() throws Exception{
       //1 - open browser
       //2 - got to https://www.google.com
       // WebDriver driver = WebDriverFactory.getDriver("chrome") ;
        //driver.get("https://www.google.com");
       //3 search "apple
        WebElement appleSearchBox = driver.findElement(By.name("q"));
        appleSearchBox.sendKeys("apple"+ Keys.ENTER);


       //4 - verify apple contains "apple
        String expectedInTtile = "apple";
        String actualTitle = driver.getTitle();

       // Assert.assertEquals(expectedInTtile,actualTitle);

        Assert.assertTrue(actualTitle.contains(expectedInTtile));
        //5 = close browser
        //Thread.sleep(2000);
        //driver.close();

    }
}

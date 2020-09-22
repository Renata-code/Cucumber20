package test.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class CssSelectorExample {

    public static void main(String[] args) throws Exception {

       //Search amazon
       //1. open browser
       //2.Go to https://amazon.com
       //3.Enter any search term (use css Selector to locate search box
       //4.Verify title contains the search

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");
      //3.
        WebElement amazonSearch = driver.findElement(By.cssSelector("input[tabindex ='19"));
        amazonSearch.sendKeys("wooden spoon" + Keys.ENTER);

        String actualTitle=driver.getTitle();
        String expectedTitle= "wooden spoon";

        Thread.sleep(1000);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }




    }

}

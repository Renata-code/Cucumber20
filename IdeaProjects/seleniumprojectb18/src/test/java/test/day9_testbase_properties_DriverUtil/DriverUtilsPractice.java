package test.day9_testbase_properties_DriverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DriverUtilsPractice {

   @Test
   public void driver_practice(){

       Driver.getDriver().get("https://www.google.com");
       //Singleton.getWord();
        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));
       googleSearch.sendKeys(ConfigurationReader.getProperty("testdata")+ Keys.ENTER);



   }





}

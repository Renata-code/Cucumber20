package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsPractices {

    @Test
    public void scrolling_with_actions(){
         //get our page
        Driver.getDriver().get("http://practice.cybertekschool.com/");

         //creating actions instance to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        //using actions instance we use movetoElement method
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        actions.moveToElement(cybertekSchoolLink).perform();



    }

    @Test
    public void tc16_double_click_test(){

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions (Driver.getDriver());

        actions.doubleClick(textToDoubleClick).perform();

        String actual = textToDoubleClick.getAttribute("style");
        String expected  = "color: red;";

        Assert.assertTrue(actual.equals(expected));


    }
}

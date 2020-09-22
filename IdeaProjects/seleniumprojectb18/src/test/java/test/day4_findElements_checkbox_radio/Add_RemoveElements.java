package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class Add_RemoveElements {


 /*
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/add_remove_elements
    3. Click to “Add Element” button 50 times
    4. Verify 50 “Delete” button is displayed after clicking.
    5. Click to ALL “Delete” buttons to delete them.
    6. Verify “Delete” button is NOT displayed after clicking.
    USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method

      */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        for(int i =0;i<50;i++) {

            driver.findElement(By.xpath("//button[@onclick = 'addElement()']")).click();

        }
        //verify 50 "Delete"button is displayed after checking
        List<WebElement>listOfDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("number of delete buttons on the page "+listOfDeleteButtons.size());
       WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        for(WebElement button:listOfDeleteButtons){
            button.click();
        }
        try {
            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete button is not displayed.Pass");
            } else {
                System.out.println("Delete button is displayed.Fail");
            }
        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown");
            System.out.println("It means element has been completely deleted from HTML");
            System.out.println("Delete button is not displayed .Verification passed");
        }








    }
}


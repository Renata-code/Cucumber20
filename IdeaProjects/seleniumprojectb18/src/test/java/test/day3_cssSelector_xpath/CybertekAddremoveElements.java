package test.day3_cssSelector_xpath;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class CybertekAddremoveElements {

    public static void main(String[] args) {
        /*


        TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
         1. Open Chrome browser
         2. Go to http://practice.cybertekschool.com/add_remove_elements
         3. Click to “Add Element” button
         4. Verify “Delete” button is displayed after clicking.
         5. Click to “Delete” button.
         6. Verify “Delete” button is NOT displayed after clicking.
          USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements");
        //driver.findElement()


    }
}

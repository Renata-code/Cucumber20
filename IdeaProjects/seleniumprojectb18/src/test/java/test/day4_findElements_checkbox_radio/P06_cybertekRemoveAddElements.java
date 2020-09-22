package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;
//open chrome browser
//go to webpage
//click to Add Element"button
//verify "Delete" i sdisplayed after clicking
//Click to delete button
//verify the delete button is not displayed after clicking

public class P06_cybertekRemoveAddElements {
//a[@class='ac-gn-link ac-gn-link-support']
    public static void main(String[] args) throws Exception {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        //click on add Element button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed");
        }else{
            System.out.println("Delete button is not displayed");
        }
        //click on delete button
        try {
            deleteButton.click();
            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete button is not displayed.Pass");
            } else {
                System.out.println("Delete button is displayed.Fail");
            }
        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown");
            System.out.println("I means element has been completely deleted from HTML");
            System.out.println("Delete button is not displayed .Verification passed");
        }
    }
}

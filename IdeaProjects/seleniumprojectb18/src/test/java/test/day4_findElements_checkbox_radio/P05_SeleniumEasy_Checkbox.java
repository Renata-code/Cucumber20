package test.day4_findElements_checkbox_radio;
/*	#2:	SeleniumEasy	CheckboxVerification–Section
	1.Open	Chrome	browser
	2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
	3.Verify	“Success	–Check	box	is	unchecked”	message	is	NOT displayed.
	4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
	5.Verify	“Success	–Check	box	is	checked”	message	is displayed

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Checkbox {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement Success = driver.findElement(By.xpath("//input[@type='checkbox']"));

        if(Success.isSelected()){
            System.out.println("Checkbox is unchecked message is displayed");
        }else{
            System.out.println("Checkbox is unchecked message is not displayed");
        }

        driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();

        WebElement boxChecked = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement mesageDisplayed = driver.findElement(By.xpath("//div[@id ='txtAge']"));

        if(boxChecked.isSelected()&&mesageDisplayed.isDisplayed()){
            System.out.println("Checkbox checked and message is displayed");
        }else {
            System.out.println("Checkbox unchecked and message is NOT displayed");
        }






    }



}

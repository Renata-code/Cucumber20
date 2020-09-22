package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {

    public static void main(String[] args) {

        /*TC #3: PracticeCybertek/ForgotPassword URL verification
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/forgot_password
        3.Enter any email into input box
        4.Click on Retrieve password
        5.Verify URL contains: Expected: “email_sent”
        6.Verify textbox displayed the content as expected.
        Expected: “Your e-mail’s been sent!
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //Enter an eamil into box
        WebElement emailInput = driver.findElement(By.name("email"));

        emailInput.sendKeys("anyemail@email.com");

        WebElement retrievepassword = driver.findElement(By.id("form_submit"));
         //#4
        retrievepassword.click();
        //#5
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        System.out.println("The current URL: "+actualURL);



        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification passed");
        }else{
            System.out.println("URL verification failed");
        }
        //$6

        WebElement confirmationmessage = driver.findElement(By.name("confirmation_message"));

        String actualMessage = confirmationmessage.getText();
        String expectedMessage = "Your e-mail's been sent!";

        //System.out.println("Actual message "+actualMessage);

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Confirmation message text verification Passed");
        }else{
            System.out.println("Confirmation message text verification Failed");
        }

        if(confirmationmessage.isDisplayed()){
            System.out.println("Mesage is displayed, verification Passed");
        }else{
            System.out.println("Message is NOT displayed, verification Failed");
        }


    }


}

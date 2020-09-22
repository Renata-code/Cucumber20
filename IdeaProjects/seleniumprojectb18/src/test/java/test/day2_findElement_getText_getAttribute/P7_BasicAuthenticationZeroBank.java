package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7_BasicAuthenticationZeroBank {

    public static void main(String[] args) {
      /*
       #5: Basic authentication Zero Bank
        1.Open Chrome browser
        2.Go to http://zero.webappsecurity.com/login.html
        3.Enter username: username
        4.Enter password: password
        5.Click sign in button
        6.Verify username is displayed on the page
        7.Verify the title Zero –Account Summary
        8.Verify the link Account Summary’s href value contains: “account-summary”
        Print out results in validation formats

       */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");

        driver.findElement(By.name("submit")).click();

        String actualUsername = driver.findElement(By.linkText("username")).getText();
        String expectedUsername = "username";
        if(actualUsername.equals(expectedUsername)){
            System.out.println("Username displayed on the page verification Passed");
        }else{
            System.out.println("Username displayed on the page verification Failed");
        }
        /*
        or you can do it this way
        boolean display= false;
        String username= driver.findElement(By.linkText("username")).getText();
        if(username.equals("username")){
            display=true;
        }
        System.out.println(display);
​
        System.out.println(driver.findElement(By.linkText("username")).getText());

         */
        String actualAccountSummary = driver.findElement(By.id("account_summary_tab")).getText();
        String expectedAccountSummary = "Account Summary";

        if(actualAccountSummary.equals(expectedAccountSummary)){
            System.out.println("The summary verification passed");
        }else{
            System.out.println("The summary verification failed");
        }

        String actualLinkAccountSummary = driver.findElement(By.linkText("Account Summary")).getAttribute("href");

        String expectedLinkAccountSummary = "account-summary";


        if(actualLinkAccountSummary.contains(expectedLinkAccountSummary)){
            System.out.println("Verification of Link account summary passed");
        }else{
            System.out.println("Verification of Link account summary failed");
        }





    }
}

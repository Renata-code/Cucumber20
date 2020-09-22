package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankURLVerification {

    public static void main(String[] args) {

        //#4: Zero Bank URLverification
        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        // 3.Get attribute value of href from the “forgot your password”link
        // 4.Verify attribute value
        // containsExpected: “/forgot-password.htm

        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");


       // 3.Get attribute value of href from the “forgot your password”link
        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));


        String actualHrefValue = forgotPasswordLink.getAttribute("href");
        String expectedHrefValue = "/forgot-password.html";

        System.out.println("actualHrefValue= " +actualHrefValue);

        if(actualHrefValue.contains(expectedHrefValue)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        System.out.println("Is forgot password displayed? "+ forgotPasswordLink.isDisplayed());




    }
}

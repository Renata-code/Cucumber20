package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P8_ZeroBankURLverification {

    public static void main(String[] args) {

        /*#4: Zero Bank URLverification
        1.Open Chrome browser
        2.Go to http://zero.webappsecurity.com/login.html
        3.Get attribute value of href from the “forgot your password”link
        4.Verify attribute value containsExpected: “/forgot-password.html”

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");

        String actualAttValue = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
        String exceptedAttValue = "/forgot-password.html";

        if(actualAttValue.contains(exceptedAttValue)){
            System.out.println("Attribute value verification passed");
        }else{
            System.out.println("Attribute value verification failed");
        }



    }
}

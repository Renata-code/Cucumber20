package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*Back and forth navigation
1-Open a chrome browser
2-Go to: https://google.com
3-Click to Gmail from top right.
4-Verify title contains:Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:Expected: Google

 */

public class P3_LinkTextLocator {

    public static void main(String[] args) {
         //open chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //2 = click to Gmail
        driver.findElement(By.linkText("Gmail")).click();
        //3 Verify title contains Gmail, expected: "Gmail

        String actualGmailTitle = driver.getTitle();
        String expecteInTitle ="Gmail";

        if (actualGmailTitle.contains(expecteInTitle)){
            System.out.println("Gmail title verification passed");
        }else{
            System.out.println("Gmail title verification failed");
        }
        driver.navigate().back();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification passed");
        }else{
            System.out.println("Google title verification failed");
        }

    }
}

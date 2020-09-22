package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBear_TitleVerification {

    public static void main(String[] args) {

        /*1-Open	a	chrome	browser
        2-Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        3-Verify	title equals:Expected:	Web	Orders	Login
        4-Enter  username:	Tester
        5    -Enter password: test
        6-Click	“Sign	In”	button
        7-Verify	title equals:Expected:
        		Web	Order

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle1 = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if(actualTitle1.equals(expectedTitle)){
            System.out.println("Home Page title verification PASSED");
        }else{
            System.out.println(" Home page title verification Failed");

        }
          //Enter username; Tester

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");

          //eneter password ;test
         driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
          //click"Sign In button

        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        //verify title equals
        //expected web browser
          //actual                    expected title
        if(driver.getTitle().equals("Web Orders")){
            System.out.println("Landing Page title verification passed");
        }else{
            System.out.println("Landing page title verification failed");
        }



    }
}

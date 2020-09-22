package test.day3_cssSelector_xpath;
/*TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered byCybertek School” text
4. Verify all WebElements are displayed.

 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Forgot_passwordVerification {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement homelink = driver.findElement(By.cssSelector("[class='nav-link']"));//a[@class='nav-link']
        WebElement forgotPassword = driver.findElement(By.cssSelector("h2"));//h2[.='Forgot Password']
        WebElement EmailText = driver.findElement(By.cssSelector("label[for=email]"));//label[@for='email']
        WebElement EmailInputBox = driver.findElement(By.cssSelector("input[type = 'text']"));//input[@type ='text']
        WebElement RetrievepasswordButton = driver.findElement(By.cssSelector("i[class ]"));//i[@class='icon-2x icon-signin']
        WebElement byCybretekschooltext = driver.findElement(By.cssSelector("div[style]"));//div[@style ='text-align: center;']

        if(homelink.isDisplayed()){
            System.out.println("homelink displayed");
        }else{
            System.out.println("homelink not displayed");
        }
        if(forgotPassword.isDisplayed()){
            System.out.println("Forgot password is displayed");
        }else{
            System.out.println("Forgot password not displayed");
        }
        if(EmailText.isDisplayed()){
            System.out.println("Email text is displayed");
        }else{
            System.out.println("Email text is not displayed");
        }
        if (EmailInputBox.isDisplayed()){
            System.out.println("Email input box is displayed");
        }else{
            System.out.println("Email input box is not displayed");
        }
        if(RetrievepasswordButton.isDisplayed()){
            System.out.println("Retrieve password button is displayed");
        }else{
            System.out.println("Retrieve password button is not displayed");
        }
         if (byCybretekschooltext.isDisplayed()){
             System.out.println("Powered by Cybertek school text is displayed");
         }else{
             System.out.println("Powered by Cybertek school text is not displayed");
         }





    }


}

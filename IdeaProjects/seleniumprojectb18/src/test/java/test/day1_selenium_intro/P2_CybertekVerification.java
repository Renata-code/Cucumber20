package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekVerification {

    /**
     * TC #2: Cybertek verifications
     * 1. Open Chrome browser
     * 2. Go to http://practice.cybertekschool.com
     * 3. Verify URL contains
     * Expected: cybertekschool
     * 4. Verify title:
     * Expected: Practice
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        String curentURL = driver.getCurrentUrl();

        String currentTitle = driver.getTitle();
        String exceptedTitle = "Practice";

        if(curentURL.contains("cybertekschool")){
            System.out.println("URL verified");
        }else{
            System.out.println("URL not verified");
        }

        if(currentTitle.equalsIgnoreCase(exceptedTitle)){
            System.out.println("Verified Title");
        }else{
            System.out.println("Unverified Title");
        }


    }
}

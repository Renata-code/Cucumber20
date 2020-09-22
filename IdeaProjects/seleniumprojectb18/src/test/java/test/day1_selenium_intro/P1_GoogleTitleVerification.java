package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class P1_GoogleTitleVerification {

    public static void main(String[] args) {


        //T #1:	Google	Title	Verification

        //1.Open	Chrome	browser
        //set up my webdriver
        WebDriverManager.chromedriver().setup();

        //2.Go to	https://www.google.com3.Verify	title:
        WebDriver driver =new ChromeDriver();

       driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        String expectTitle = "Google";

       if(driver.getTitle().equals("Google")){
           System.out.println("Google title verification passed");
       }else{
           System.out.println("Google title verification failed");
       }



    }

}

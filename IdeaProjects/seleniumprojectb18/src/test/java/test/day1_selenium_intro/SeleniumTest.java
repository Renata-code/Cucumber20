package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException{

        //1 set the web driver,line creates the connection between driver and selenium
        WebDriverManager.chromedriver().setup();//sets up the driver
        //2 create the instance of the chromedriver do able actions in chromeBrowser
        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();//this line maximize the page after opening it.
        //driver.manage().window().fullscreen(); this line does the same --> maximize the page
        //3 - test if driver is working
        driver.get("https://www.google.com");

        System.out.println("driver.getTitle()--> "+driver.getTitle());//returns the title of the current page as a String
        //return type is String
        //it does not except any pararmetr
         //this line wil take you to the previous page

        Thread.sleep(2000);//this line adds 2000milliseconds of wait = 2 seconds
        driver.navigate().back();

        Thread.sleep(2000);// therad.sleep added to see selenium movements,this line will go to nex page
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().refresh();//this line will refresh your page

        driver.navigate().to("https://www.facebook.com");

        System.out.println("driver.getTitle()--> "+driver.getTitle());

        System.out.println("driver.getCurrentUrl()--> "+driver.getTitle());

        driver.close(); //will close the current browser tab
        driver.quit();  //will close all the tabs and ends the session

        //pkill -9 closes all tabs,windows

    }
}

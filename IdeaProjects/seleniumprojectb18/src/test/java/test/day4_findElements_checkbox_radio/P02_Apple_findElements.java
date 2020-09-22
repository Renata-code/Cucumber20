package test.day4_findElements_checkbox_radio;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*
TC #02: FINDELEMENTS_APPLE
1.Open Chrome browser
2.Go to https://www.apple.com
3.Click to iPhone
4.Print out the texts of all links
5.Print out how many link is missing text
6.Print out how many link has text
7.Print out how many total link
 */

public class P02_Apple_findElements {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //3.Click to iPhone
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
        //4.Print out the texts of all links
        List<WebElement>iPhoneLinks = driver.findElements(By.xpath("//body//a"));
        //5.Print out how many link is missing text
         int linkWithoutText =0;
         int linkWithText =0;

        for(WebElement eachLink : iPhoneLinks) {
            String texOfEachLink = eachLink.getText();

            if(texOfEachLink.isEmpty()){
                linkWithoutText++;
            }else{
                linkWithText++;
            }
        }
        System.out.println("The number of Link with text "+linkWithText);
        System.out.println("The number of Link without text "+linkWithoutText);
        System.out.println("The number of total links "+ iPhoneLinks.size());
    }
}

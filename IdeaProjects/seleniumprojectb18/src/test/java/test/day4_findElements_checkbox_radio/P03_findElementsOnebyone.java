package test.day4_findElements_checkbox_radio;
/*#03: FINDELEMENTS_APPLE
1.Open Chrome browser
2.Go to https://www.apple.com
3.Click to all of the headers one by onea.Mac, iPad, iPhone, Watch, TV, Music, Support
4.Printout how many links on each page with the titles of the pages
5.Loop through all
6.Print out how many link is missing textTOTAL
7.Print out how many link has textTOTAL
8.Print out how many total linkTOTA
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class P03_findElementsOnebyone {

    public static void main(String[] args) throws Exception{

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.apple.com");

        List<WebElement>appleheaders = driver.findElements(By.xpath("//ul[@class ='ac-gn-list']/li/a"));

        for(int i =1;i<8;i++){

            appleheaders.get(i).click();
            Thread.sleep(1000);

            List<WebElement>listOfLinks = driver.findElements(By.xpath("//body//a"));

            System.out.println("Number of links on page: " +driver.getTitle()+" "+listOfLinks.size());

            int LinkswithText =0;
            int LinksWithoutText =0;
            int TotalLinks =0;

            for(WebElement link : listOfLinks){
                String textOfLink = link.getText();
                if(!textOfLink.isEmpty()){
                    LinkswithText++;
                }else{
                    LinksWithoutText++;
                }
            }
            driver.navigate().back();
            appleheaders=driver.findElements(By.xpath("//ul[@class ='ac-gn-list']/li/a"));
            System.out.println("Number of EmptyLinks: \t"+ LinksWithoutText);
            System.out.println("Number of Links with text: \t"+LinkswithText);
            System.out.println("Numbers of total links \t"+ appleheaders.size());

        }

    }

}

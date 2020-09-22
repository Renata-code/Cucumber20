package test.day4_findElements_checkbox_radio;

/*TC #0: FINDELEMENTS1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P01_MerriemWebster_findElements {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");
        driver.manage().window().maximize();

        //implicit wait will wait up to given seconds
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //3.Print out the texts of all links
        //create a list of elements
        List<WebElement>listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText =0;
        int linkswithtext =0;

        for(WebElement eachLink : listOfLinks) {
            String texOfEachLink = eachLink.getText();

            //4.Print out how many link is missing text

            if(texOfEachLink.isEmpty()){
                linksWithoutText++;
            }else{
                linkswithtext++;
            }


        }
        System.out.println("The number of Link with text "+linkswithtext);
        System.out.println("The number of Link without text "+linksWithoutText);
        System.out.println("The number of total links "+ listOfLinks.size());








    }
}

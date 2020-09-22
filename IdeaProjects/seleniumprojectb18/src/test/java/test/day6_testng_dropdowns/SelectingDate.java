package test.day6_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import java.util.ArrayList;
import java.util.List;

public class SelectingDate {
    //TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        //driver.close();
        //driver.quit();
    }
    //3.Select “December 1st, 1921” and verify it is selected.
    // Select year using: visible text
    // Select month using : value attributeSelect
    // day using: index number
     @Test(priority = 1)
    public void SelectYear() throws Exception{

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Thread.sleep(2000);
        year.selectByVisibleText("1921");
        Thread.sleep(2000);
        String exceptedYear ="1921";
        String actualYear = year.getFirstSelectedOption().getText();

         Select month =new Select (driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        Thread.sleep(2000);
        String exceptedMonth ="December";
        String actualMonth = month.getFirstSelectedOption().getText();

        Select day = new Select (driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
        Thread.sleep(2000);

        String exceptedDay = "1";
        String actualDay = day.getFirstSelectedOption().getText();

        Assert.assertEquals(exceptedMonth,actualMonth);
        Assert.assertEquals(exceptedDay,actualDay);
        Assert.assertEquals(exceptedYear,actualYear);

    }


    @Test(priority = 2)
    public void SelectOptions()throws Exception{

        //select the all the options from multiple select dropdown

     Select multipleOptions = new Select (driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> list = multipleOptions.getOptions();
        for(int i =0;i<list.size();i++){
            multipleOptions.selectByIndex(i);
            Thread.sleep(1000);
        }
        //print out all selected values

        List <WebElement> AllSelected = multipleOptions.getAllSelectedOptions();
        for(WebElement item :AllSelected){
            System.out.println(item.getText());
        }
        multipleOptions.deselectAll();
        Thread.sleep(1000);

        /* //Getting all of the options from dropdown and storing them into list of web elements
        List<WebElement> allOptions = languagesDropdown.getOptions();

        //Looping through the options and selecting them
        for(WebElement option : allOptions){
            option.click();
            System.out.println("Selected: " + option.getText());

            //Doing the assertion after selecting
            Assert.assertTrue(option.isSelected());
        }

        languagesDropdown.deselectAll();

        //Asserting they are de-selected
        for (WebElement option1 : allOptions) {
            Assert.assertFalse(option1.isSelected());
        }
        //driver.close();
        //Use all Select options.
    }
         */

    }
    @Test(priority = 3)
    public void NonSelectDropDown()throws Exception{
         //Select Facebook from dropdown
         driver.findElement(By.xpath("//a[@class ='btn btn-secondary dropdown-toggle']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//a[.='Facebook']")).click();

         //Verify title is"Facebook -Log in or Sign Up"

        String  expectedFacebookTitle = "Facebook - Log In or Sign Up";
       // String exceptedTitle = driver.findElement(By.xpath("//div [@id='globalContainer']")).getText();

       // for(int i =0;i<actualTitle.length;i++){
          //  exceptedTitle =actualTitle[i];

       // Assert.assertEquals(actualTitle[i],exceptedTitle);

       // }


        //String getting the actual title
        String  actualTitle = driver.getTitle();
        //Asserting actual vs expected
        Assert.assertEquals(actualTitle, expectedFacebookTitle);




    }


}

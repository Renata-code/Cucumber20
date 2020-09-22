package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {
    //TC #1: Smartbear software link verification
// 1.Open browser
// 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
// 3.Enter username: "Tester"
// 4.Enter password: "test"
// 5.Click to Login button
// 6.Print out count of all the links on landing page
// 7.Print out each link text on this page

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #1: Smartbear software link verification
        // 1.Open browser
        // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);

        /*
        // 3.Enter username: "Tester"
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();



         */
    }


        @Test
        public void p1_smartbear_login_test(){
            // 6.Print out count of all the links on landing page

            List<WebElement>allLinks = driver.findElements(By.xpath("//body//a"));

            int expectedNumberOfLinks = 6;
            int actualNumberOflinks =allLinks.size();

            Assert.assertEquals(actualNumberOflinks,6);

            // 7.Print out each link text on this page

            for(WebElement link: allLinks){
                System.out.println(link.getText());
            }

        }


        @Test
        public void p2_smartbear_order_placing() throws Exception{
        /*
            TC#2: Smartbear software order placing
            1. Open browser
            2. Go to website:
            http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            3. Enter username: "Tester"
            4. Enter password: "test"
            5. Click on Login button
            6. Click on Order
            7. Select familyAlbum from product, set quantity to 2
            8. Click to "Calculate" button
            9. Fill address Info with JavaFaker
             Generate: name, street, city, state, zip code
            10. Click on "visa" radio button
            11. Generate card number using JavaFaker
            12. Click on "Process"
            13.Verify success message "New order has been successfully added."
         */

        // 6. Click on Order
            //  7. Select familyAlbum from product, set quantity to 2
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        Thread.sleep(1000);

        //quantityInput.clear();//just deletes if there is any existing input in the input box or .sendKeys(Keys.Backspace+"2")
        //quantityInput.sendKeys("2");
        quantityInput.sendKeys(Keys.BACK_SPACE+"2");
            //quantityInput.sendKeys(Keys.DELETE+"2");
            //driver.findElement(By.xpath())
             //Click to calculate button
            WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
            calculateButton.click();
            // Fill address with JavaFaker
            WebElement customerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
            WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
            WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
            WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
            WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

            Faker faker = new Faker();

            customerName.sendKeys(faker.name().firstName());
            inputStreet.sendKeys(faker.address().streetName());
            inputCity.sendKeys(faker.address().city());
            inputState.sendKeys(faker.address().state());
            inputZip.sendKeys(faker.address().zipCode().replaceAll("-",""));

            //Click on "visa" radio button

            WebElement VisaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
            VisaRadioButton.click();

             //generate card number by using JavaFaker

            WebElement inputcardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
            inputcardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

            WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
            expirationDate.sendKeys("12/25");
            //String expirydate= faker.business().creditCardExpiry().substring(0,2) +
            // "/" + faker.business().creditCardExpiry().substring(2)          in case of using faker

            WebElement processButton = driver.findElement(By.xpath("//a[.='Process']")) ;
            processButton.click();

            WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
            Assert.assertTrue(successMessage.isDisplayed());

        }
        @Test
        public void OrderVerification(){

        WebElement ViewAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        ViewAllOrders.click();

        //String actualOrder = "01/05/2010";
        //String expectedOrder =
            WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
            String expectedDate = "01/05/2010";
            String actualdate = susansDate.getText();

            Assert.assertEquals(actualdate,expectedDate);////td[. = 'Susan McLaren']/following-sibling::td[3]



        }






}

package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1.Create	a	new	class	called:	WindowHandlePractice
        // 2.Create	new	test	and	make	set	ups
        // 3.Go	to	:	http://practice.cybertekschool.com/windows4.Assert:	Title	is	“Practice”
        // 5.Click	to:	“Click	Here”text
        // 6.Switch	to	new	Window.
        // 7.Assert:	Title	is	“New	Window


    }
    @Test
    public void p5_window_handle_practice(){

        String currentWindowHandle = driver.getWindowHandle();

        System.out.println("CurrentwindowHanler= "+ currentWindowHandle);

        WebElement clickhereLink = driver.findElement(By.xpath("//a[.='Click Here']"));

        clickhereLink.click();

        //driver.getWindowHandles() --> us A set of Strings

        Set<String> windowHandles = driver.getWindowHandles();


        for (String each : windowHandles){
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());
        }


    }
}

package test.day10_jsecutor_upload_actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Uploading {

    @Test
    public void uploading_test()throws Exception{

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));

        Thread.sleep(3000);

        chooseFile.sendKeys("/Users/renatasaidjanova/Desktop/test");

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.click();

        WebElement uploadMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        Assert.assertTrue(uploadMessage.isDisplayed());


    }



    @Test (priority =1)
    public void double_Click(){

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));

        Driver.getDriver().switchTo().frame(iframe);

        WebElement doubleClick = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

        Actions action = new Actions(Driver.getDriver());

        action.doubleClick(doubleClick).perform();

        WebElement styleText  = Driver.getDriver().findElement(By.xpath("//p[@style = 'color: red;']"));

        Assert.assertTrue(doubleClick.getAttribute("style").contains("red"));
    }

    @Test(priority=2)
    public void Drag_N_Drop(){

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement smallCircle  = Driver.getDriver().findElement(By.xpath("//div[@data-role='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@class='k-header']"));

        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(smallCircle,bigCircle).perform();
        //or we can use this
        // action.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

        Assert.assertTrue(bigCircle.getText().contains("You did great"));

    }
    @Test(priority=3)
    public void Context_Click() throws Exception{

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        Actions action = new Actions(Driver.getDriver());

        action.contextClick(box).perform();

        Thread.sleep(2000);

        Alert alert = Driver.getDriver().switchTo().alert();

        Thread.sleep(1000);

        alert.accept();






    }


}

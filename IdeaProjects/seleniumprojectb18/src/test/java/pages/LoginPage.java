package pages;

//we will store all login page related web elements and methods into this class

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    //locating usernameInput
    @FindBy(id="prependedInput")
    public WebElement usernameInput;

    //locating input password

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginButton;

      //locating error message
    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement errorMessage;

    //locating forgot your password link
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;


    public void login(String username,String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();



    }


}

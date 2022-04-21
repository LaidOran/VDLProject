package PagesObjects;

import Configs.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends base {
    public WebDriver driver;
    @FindBy(xpath="//a[text()='Forgot your password?']")
    private WebElement BtnForgotYourPasseword;
    @FindBy(xpath="//input[@name='email']")
    private WebElement username;
    @FindBy(xpath="//input[@name='password']")
    private WebElement password;
    @FindBy(xpath="//div[text()='Login']")
    public WebElement loginBtnLoginPage;
    @FindBy(xpath="//div[contains(text(),'Something went wrong')]")
    private WebElement WrongAuthentication;
    public LoginPage(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(base.driver, this);
    }
    public String LoginPageTitle() {
        return driver.getTitle();
    }
    public boolean ButtonForgotYourPasseword(){
        return BtnForgotYourPasseword.isEnabled();
    }
    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtnLoginPage.click();
        return new HomePage(driver);
    }
    public HomePage login(String un, String pwd, String etat){
        username.clear();
        username.sendKeys(un);
        password.clear();
        password.sendKeys(pwd);
        loginBtnLoginPage.click();
        return new HomePage(driver);
    }
    public boolean WrongAuthentMessage(){
        return WrongAuthentication.isDisplayed();
    }

}

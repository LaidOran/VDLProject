package PagesObjects;

import Configs.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends base {
    public WebDriver driver;
    @FindBy(xpath="//span[text()='Laid Fodil']")
    public WebElement userNameLabel;
//    public WebElement getUserNameLabel() {
//        return userNameLabel;
//    }
    @FindBy(xpath="(//i[@class='settings icon'])[1]")
    private WebElement settings;
    @FindBy(xpath="//span[text()='Log Out']")
    private WebElement LogOut;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String HomePageTitle()
    {
        return driver.getTitle();
    }
    public boolean CorrectUserName(){
        return userNameLabel.isEnabled();
    }
    public void LogOutHomePage(){
        settings.click();
        LogOut.click();
    }
}

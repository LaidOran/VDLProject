package PagesObjects;

import Configs.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends base {

    public WebDriver driver;
    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    private WebElement crmLogo;
    @FindBy(xpath="//a[text()='Login']")
    public WebElement loginBtnLandingPage;
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String LandingPageTitle(){
        return driver.getTitle();
    }
    public boolean LandingPageCRMLogo(){
        return crmLogo.isDisplayed();
    }
    public LoginPage getLogin(){
        loginBtnLandingPage.click();
        return new LoginPage(driver);
    }
}

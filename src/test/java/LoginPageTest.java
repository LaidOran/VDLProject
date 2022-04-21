import Configs.TestUtil;
import Configs.base;
import PagesObjects.HomePage;
import PagesObjects.LandingPage;
import PagesObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends base {
    //public WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeClass
    public void setUp() throws IOException {
        initialization();
        landingPage = new LandingPage(driver);
        TestUtil.waitForElementIsVisible(landingPage.loginBtnLandingPage ,10);
        loginPage = landingPage.getLogin();
        TestUtil.waitForElementIsVisible(loginPage.loginBtnLoginPage ,10);
    }
    @Test(priority=1,description = "Valider le titre - LoginPage")
    public void validateLogingPageTitle(){
        String title = loginPage.LoginPageTitle();
        Assert.assertEquals(title, "Cogmento CRM");
    }
    @Test(priority=2,description = "Valider la presence du bouton (Forgot your passeword)- LoginPage")
    public void validateBtnForgotYourPasseword(){
        boolean logo = loginPage.ButtonForgotYourPasseword();
        Assert.assertTrue(logo);
    }
    @Test(priority=3,description = "S'euthentifier")
    public void loginTest(){
        homePage  =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

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

public class HomePageTest extends base {
    //public WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;

    //public HomePageTest(){
    // super();
    // }
    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        initialization();
        landingPage = new LandingPage(driver);
        TestUtil.waitForElementIsVisible(landingPage.loginBtnLandingPage ,10);
        loginPage = landingPage.getLogin();
        TestUtil.waitForElementIsVisible(loginPage.loginBtnLoginPage ,10);
        homePage  =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        TestUtil.waitForElementToDisplay(homePage.userNameLabel,3000);

    }
    @Test(priority=1,description = "Valider le titre - HomePage")
    public void validateHomePageTitle(){
        String title = homePage.HomePageTitle();
        Assert.assertEquals(title, "Cogmento CRM");
    }
    @Test(priority=2,description = "Valider l'exactitude du UserName HomePage")
    public void validateCorrectUserName(){
        Assert.assertTrue(homePage.CorrectUserName());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

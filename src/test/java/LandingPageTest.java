import Configs.TestUtil;
import Configs.base;
import PagesObjects.LandingPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LandingPageTest extends base {
    //public WebDriver driver;
    LandingPage landingPage;
    @BeforeClass
    public void setUp() throws IOException {
        initialization();
        landingPage = new LandingPage(driver);
        TestUtil.waitForElementIsVisible(landingPage.loginBtnLandingPage ,10);
    }
    @Test(priority=1,description = "Valider le titre - landingPage")
    public void validateLandingPageTitle(){
        String title = landingPage.LandingPageTitle();
        Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
    }
    @Test(priority=2,description = "Valider le logo- landingPage")
    public void validatecrmLogoTest(){
        boolean logo = landingPage.LandingPageCRMLogo();
        Assert.assertTrue(logo);
    }
    @Test(priority=3,description = "Cliquer sur login")
    public void loginTest()
    {
        landingPage.getLogin();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

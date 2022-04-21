package Configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static WebDriver driver;
    public static Properties prop;
    public base() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static WebDriver initialization() throws IOException
    {

        String browserName = prop.getProperty("browser");  //Lorsque systeme penrd les données depuis data.propertises
        //String browserName = System.getProperty("browser");  //Lorsque le build par ligne de commande (mvn) ou par jenkins le systeme ne penrd pas les données depuis data.propertises

        if(browserName.contains("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            if(browserName.contains("headless"))
            {
                chromeOptions.addArguments("headless");
            }
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browserName.contains("FF"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions FFOptions = new FirefoxOptions();
            if(browserName.contains("headless"))
            {
                FFOptions.setHeadless(true);
            }
            driver = new FirefoxDriver(FFOptions);
        }
        else if (browserName.contains("edge"))
        {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            if(browserName.contains("headless"))
            {
                edgeOptions.addArguments("headless");
            }
            driver = new EdgeDriver(edgeOptions);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        return driver;
    }
}

package Configs;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static Configs.base.driver;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    //******Data***************************************************************************
    public static String path = ".\\src\\main\\resources\\loginData.xlsx";
    public static FileInputStream file;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public static Object[][] getTestData(String sheetName) throws IOException {
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        workbook = new XSSFWorkbook(file);
        sheet =workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }
    //************************************************Wait intil is visible********************************
    public static WebElement waitForElementIsVisible(WebElement element, long duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static boolean waitForElementToDisplay(WebElement element, int timeOutInSeconds) {
        boolean isDisplayed = false;
        for(int i=0; i<timeOutInSeconds; i++) {
            if(element.isDisplayed()){
                isDisplayed = true;
                break;
            }
        }
        return isDisplayed;
    }

}

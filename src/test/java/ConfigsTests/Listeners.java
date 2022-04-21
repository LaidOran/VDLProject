package ConfigsTests;

import Configs.ExtendReport;
import Configs.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends TestUtil implements ITestListener {
    ExtentTest test;
    ExtentReports extent= ExtendReport.getReport();
    // ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {

        test= extent.createTest(result.getMethod().getMethodName());
        //extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();

        try {
           driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

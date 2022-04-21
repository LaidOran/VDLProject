package Configs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
    static ExtentReports extent;

    public static ExtentReports getReport()
    {

        String path =System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Free CRM");
        reporter.config().setDocumentTitle("Laid Fodil");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Laid Fodil");
        return extent;
    }
}

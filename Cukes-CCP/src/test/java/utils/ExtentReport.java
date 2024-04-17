package utils;

import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import StepDefinitions.TestBase;

public class ExtentReport {

	public static ExtentReports extent;
	

	final static String filePath = "Extent.html";

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter("Extent.html");
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("CCP");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().thumbnailForBase64(true);
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}

		return extent;

	}

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
	      ExtentTest Logger = getReporter().createTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), Logger);

		return Logger;
	}
	
	

}

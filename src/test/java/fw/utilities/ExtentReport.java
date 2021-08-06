package fw.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "nopcomm-Test-Report" + timestamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/" + reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports(reportName);
		extent.addSystemInfo("Server", "SIT");

	}

}

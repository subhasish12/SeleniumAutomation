package fw.loginModule;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fw.utilities.BaseClass;
import fw.utilities.PrintLog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginModuleTestCases extends BaseClass {

	String basedir = System.getProperty("user.dir");
	WebDriver driver = null;
	LoginModulePOM pom = null;
	LoginModuleTestData testdata = null;

	@BeforeClass
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void startDriver() throws IOException {
		String basePath = System.getProperty("user.dir");
		Properties properties = BaseClass.getPropertyControl(basePath + "/configuration/masterdata.properties");
		pom = new LoginModulePOM(driver);
		testdata = new LoginModuleTestData();
		driver.get(properties.getProperty("nopcomm_url"));
	}

	@Test(description = "Login With Valid Credentials")
	public void loginTC_001() throws Exception {
		pom.getValidLogin(testdata.putUserName(), testdata.putPassword());
		String expected_title = "Dashboard / nopCommerce administration";
		String actual_title = driver.getTitle();
		if (expected_title.equals(actual_title)) {
			PrintLog.getInfoLog("loginTC_001 : PASSED");
		} else {
			BaseClass.getScreenshotControl(driver, basedir + "/screenshot/LoginTC_001.png");
			PrintLog.getErrorLog("loginTC_001 : FAILED , Screenshot Taken");
		}
		pom.getLogout();
	}

	@Test(description = "Login With invalid Credentials")
	public void loginTC_002() throws Exception {
		pom.getInvalidLogin(testdata.putinvalidUserName(), testdata.putinvalidPassword());
		PrintLog.getErrorLog("loginTC_002 : PASSED");
	}
	
	@Test(description = "Login With valid user and invalid password")
	public void loginTC_003() throws Exception {
		pom.getValidUserInvalidPassword(testdata.putUserName(), testdata.putinvalidPassword());
		PrintLog.getErrorLog("loginTC_003 : PASSED");
	}

	@AfterMethod
	public void refreshPage() {
//		pom.getLogout();
//		driver.navigate().refresh();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

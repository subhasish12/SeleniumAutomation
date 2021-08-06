package fw.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static Properties getPropertyControl(String path) throws IOException {
		FileInputStream filePath = new FileInputStream(path);
		Properties property = new Properties();
		property.load(filePath);
		return property;
	}

	public static void getScreenshotControl(WebDriver driver, String screenshotPath) throws Exception {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File sourceScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
		File targetScreenshot = new File(screenshotPath);
		FileUtils.copyFile(sourceScreenshot, targetScreenshot);

	}

	public static String getSpaceTrimmerControl(String StringInput) {
		String inputString = StringInput;
		String trimmedValue = inputString.trim();
		return trimmedValue;

	}

	public static ResultSet getDatabaseControl(String MySQLURL, String databseUserName, String databasePassword,
			String selectDatabase, String query) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
			if (connection != null) {
				System.out.println("Connected To DataBase !!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Statement statement = connection.createStatement();
		statement.executeQuery(selectDatabase);
		ResultSet result = statement.executeQuery(query);
		return result;
	}

	public static void getMouseoverControl(WebDriver driver, WebElement webelement) {

		Actions actions = new Actions(driver);
		actions.moveToElement(webelement).build().perform();

	}

	public static void getRightClickControl(WebDriver driver, WebElement webelement) {

		Actions actions = new Actions(driver);
		actions.contextClick(webelement).build().perform();

	}

	public static void getDragAndDropControl(WebDriver driver, WebElement sourceWebelement,
			WebElement targetWebelement) {

		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceWebelement).moveToElement(targetWebelement).release().build().perform();

	}

	public static void getSliderControl(WebDriver driver, WebElement sliderWebelement, int resizeStart, int slideEnd) {

		Actions actions = new Actions(driver);
		actions.moveToElement(sliderWebelement).dragAndDropBy(sliderWebelement, resizeStart, slideEnd).build()
				.perform();

	}

	public static void getResizeControl(WebDriver driver, WebElement resizeWebelement, int resizeStart, int resizeEnd) {

		Actions actions = new Actions(driver);
		actions.moveToElement(resizeWebelement).dragAndDropBy(resizeWebelement, resizeStart, resizeEnd).build()
				.perform();

	}

	public static Select getDropDwonControl(WebElement dropdownWebElement) {

		Select select = new Select(dropdownWebElement);
		return select;
	}

	public static void getScrollPixelControl(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
	}

	public static void getScrollTillButtonControl(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static Robot getKeyboardControl() throws AWTException {

		Robot robot = new Robot();
		return robot;
	}
}

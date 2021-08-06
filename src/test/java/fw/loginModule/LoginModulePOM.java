package fw.loginModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import fw.utilities.PrintLog;

public class LoginModulePOM {

	public WebDriver driver;

	LoginModulePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement email_text;

	@FindBy(id = "Password")
	private WebElement password_text;

	@FindBy(xpath = "//*[contains(text(),'Log in')]")
	private WebElement login_button;

	@FindBy(xpath = "//*[contains(text(),'Remember me?')]")
	private WebElement Rememberme_checkbox;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	private WebElement logout_link;

	@FindBy(xpath = "//*[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]")
	private WebElement login_error;

	public void getValidLogin(String username, String Password) throws InterruptedException {
		email_text.clear();
		password_text.clear();
		email_text.sendKeys(username);
		PrintLog.getInfoLog("getValidLogin : username entered");
		password_text.sendKeys(Password);
		PrintLog.getInfoLog("getValidLogin : password entered");
		Thread.sleep(3000);
		login_button.click();
		PrintLog.getInfoLog("getValidLogin : login button clicked");
	}

	public void getLogout() {
		logout_link.click();
		PrintLog.getInfoLog("getLogout : logout clicked");
	}

	public void getInvalidLogin(String username, String Password) throws InterruptedException {
		email_text.clear();
		password_text.clear();
		email_text.sendKeys(username);
		PrintLog.getInfoLog("getInvalidLogin : invalid username entered");
		password_text.sendKeys(Password);
		PrintLog.getInfoLog("getInvalidLogin : invalid password entered");
		Thread.sleep(3000);
		login_button.click();
		PrintLog.getInfoLog("getInvalidLogin : login button clicked");
		Assert.assertTrue(login_error.isDisplayed());
		PrintLog.getInfoLog("getInvalidLogin : error message verified");
	}
}

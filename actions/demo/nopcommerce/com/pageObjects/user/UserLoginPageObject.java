package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import demo.nopcommerce.com.pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_EMAIL);
		return getElementText(driver, UserLoginPageUI.ERROR_EMAIL);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);

	}
	
	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
		
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_UNSUCCESSFULL);
		return getElementText(driver, UserLoginPageUI.ERROR_UNSUCCESSFULL);
	}

}

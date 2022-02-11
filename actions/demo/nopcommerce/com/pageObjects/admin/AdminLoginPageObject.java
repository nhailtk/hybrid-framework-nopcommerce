package demo.nopcommerce.com.pageObjects.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GlobalConstants;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageUIs.admin.AdminLoginPageUI;
import demo.nopcommerce.com.pageUIs.user.UserLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, email);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);

	}

	public AdminDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoradPage(driver);

	}

	public AdminDashBoardPageObject loginAsAdmin(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	public boolean isAdminTitlePageDisplayed() {
		return elementIsDisplayed(driver, AdminLoginPageUI.ADMIN_TITLE_PAGE);
	}

	public UserHomePageObject getUserHomePage(WebDriver driver) {
		openPageUrl(driver, GlobalConstants.USER_URL_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}

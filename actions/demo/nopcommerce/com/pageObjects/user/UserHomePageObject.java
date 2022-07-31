package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.GlobalConstants;
import demo.nopcommerce.com.pageObjects.admin.AdminLoginPageObject;
import demo.nopcommerce.com.pageUIs.user.UserHomePageUI;
import facebook.com.pageUIs.HomePageUI;
import io.qameta.allure.Step;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register link")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getUserRegisterPage(driver);

	}

	@Step("Click to Login link")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getUserLoginPage(driver);

	}
	
	@Step("Verify myAccount link displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return elementIsDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	
	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		openPageUrl(driver, GlobalConstants.ADMIN_URL_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public boolean verifyElementIsDisplayed() {
		waitForElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return elementIsUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String registergetErrorMessageAtFirstNameTextbox() {
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR);
	}

	public String registergetErrorMessageAtLastNameTextbox() {
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR);
	}

	public String registergetErrorMessageAtEmailTextbox() {
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}

	public String registergetErrorMessageAtPasswordTextbox() {
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR);
	}

	public String registergetErrorMessageAtConfirmPasswordTextbox() {
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public String getErrorMessageWrongEmail() {
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}

	public String getSuccessMessageRegister() {
		return getElementText(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}


	public String getErrorMessageExistingEmail() {
		return getElementText(driver, RegisterPageUI.EXITSTING_EMAIL_ERROR);
	}

	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver,RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
		// return new HomePageObject(driver);
		return PageGeneratorManager.getHomePage(driver);
		
	}


}

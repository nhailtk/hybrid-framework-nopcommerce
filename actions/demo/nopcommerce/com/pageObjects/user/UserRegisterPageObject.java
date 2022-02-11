package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import demo.nopcommerce.com.pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver,UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}

	public String registergetErrorMessageAtFirstNameTextbox() {
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR);
	}

	public String registergetErrorMessageAtLastNameTextbox() {
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR);
	}

	public String registergetErrorMessageAtEmailTextbox() {
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR);
	}

	public String registergetErrorMessageAtPasswordTextbox() {
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR);
	}

	public String registergetErrorMessageAtConfirmPasswordTextbox() {
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public String getErrorMessageWrongEmail() {
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR);
	}

	public String getSuccessMessageRegister() {
		return getElementText(driver, UserRegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}


	public String getErrorMessageExistingEmail() {
		return getElementText(driver, UserRegisterPageUI.EXITSTING_EMAIL_ERROR);
	}
	
	 public void registerSuccessfull(String firstName, String lastName, String email, String password) {
		 inputToFirstNameTextbox(firstName);
		 inputToLastNameTextbox(lastName);
		 inputToEmailTextbox(email);
		 inputToPasswordTextbox(password);
		 inputToConfirmPasswordTextbox(password);
		 clickToRegisterButton();
	 }




}

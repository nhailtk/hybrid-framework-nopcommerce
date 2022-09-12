package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import demo.nopcommerce.com.pageUIs.user.UserRegisterPageUI;
import io.qameta.allure.Step;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register button")
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

	@Step("Input to firstName textbox with value: {0}")
	public void inputToFirstNameTextbox(String firstName) {
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	@Step("Input to lastName textbox with value: {0}")
	public void inputToLastNameTextbox(String lastName) {
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	@Step("Input to email textbox with value: {0}")
	public void inputToEmailTextbox(String email) {
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	@Step("Input to password textbox with value: {0}")
	public void inputToPasswordTextbox(String password) {
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	@Step("Input to confirmPass textbox with value: {0}")
	public void inputToConfirmPasswordTextbox(String password) {
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public String getErrorMessageWrongEmail() {
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR);
	}

	@Step("Get success message register")
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

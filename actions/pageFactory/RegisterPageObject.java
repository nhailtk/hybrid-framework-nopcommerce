package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lastNameTextbox;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement EmailTextbox;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	private WebElement logOutButton;
	
	@FindBy(xpath="//span[@id='FirstName-error']")
	private WebElement firstNameError;
	
	@FindBy(xpath="//span[@id='LastName-error']")
	private WebElement lastNameError;
	
	@FindBy(xpath="//span[@id='Email-error']")
	private WebElement emailError;
	
	@FindBy(xpath="//span[@id='Password-error']")
	private WebElement passwordError;
	
	@FindBy(xpath="//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordError;
	
	@FindBy(xpath="//div[@class='result']")
	private WebElement successRegisterMessage;
	
	@FindBy(xpath="//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailError;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,registerButton);
		clickToElement(driver, registerButton);
		
	}

	public String registergetErrorMessageAtFirstNameTextbox() {
		return getElementText(driver, firstNameError);
	}

	public String registergetErrorMessageAtLastNameTextbox() {
		return getElementText(driver, lastNameError);
	}

	public String registergetErrorMessageAtEmailTextbox() {
		return getElementText(driver, emailError);
	}

	public String registergetErrorMessageAtPasswordTextbox() {
		return getElementText(driver, passwordError);
	}

	public String registergetErrorMessageAtConfirmPasswordTextbox() {
		return getElementText(driver, confirmPasswordError);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		sendkeyToElement(driver, lastNameTextbox, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		sendkeyToElement(driver, EmailTextbox, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		sendkeyToElement(driver, passwordTextBox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		sendkeyToElement(driver, confirmPasswordTextBox, password);
		
	}

	public String getErrorMessageWrongEmail() {
		return getElementText(driver, emailError);
	}

	public String getSuccessMessageRegister() {
		return getElementText(driver, successRegisterMessage);
	}


	public String getErrorMessageExistingEmail() {
		return getElementText(driver, existingEmailError);
	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver,logOutButton);
		clickToElement(driver, logOutButton);
		
	}
}

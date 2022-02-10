package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement errorEmail;
	
	@FindBy(xpath = "//input[@id='Email']" )
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']" )
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement errorUnsuccesfull;
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, errorEmail);
		return getElementText(driver, errorEmail);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, errorUnsuccesfull);
		return getElementText(driver, errorUnsuccesfull);
	}

}

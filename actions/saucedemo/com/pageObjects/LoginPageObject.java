package saucedemo.com.pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import facebook.com.pageUIs.HomePageUI;
import saucedemo.com.pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	public HomePageObject clickToLoginButton(String standard_user, String password) {
		waitForElementVisible(driver, LoginPageUI.USER_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.USER_TEXTBOX, standard_user);
		
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, password);
		
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
		return PageGeneratorManager.getHomePage(driver);
	}


}

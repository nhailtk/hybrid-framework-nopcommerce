package com.jquery.pageObjects;

import org.openqa.selenium.WebDriver;

import com.jquery.pageUIs.UserPageUI;

import common.BasePage;
import common.GlobalConstants;

public class UserPageObject extends BasePage {
	WebDriver driver;

	public UserPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void registerUser(String firstName, String lastName, String email, String password) {
		waitForElementClickable(driver, UserPageUI.ACCOUNT_MENU);
		clickToElement(driver, UserPageUI.ACCOUNT_MENU);

		waitForElementClickable(driver, UserPageUI.REGISTER_SUB_MENU);
		clickToElement(driver, UserPageUI.REGISTER_SUB_MENU);

		waitForElementVisible(driver, UserPageUI.DYNAMIC_TEXTBOX, "firstname");
		sendkeyToElement(driver, UserPageUI.DYNAMIC_TEXTBOX, firstName, "firstname");

		waitForElementVisible(driver, UserPageUI.DYNAMIC_TEXTBOX, "lastname");
		sendkeyToElement(driver, UserPageUI.DYNAMIC_TEXTBOX, lastName, "lastname");

		waitForElementVisible(driver, UserPageUI.DYNAMIC_TEXTBOX, "email_address");
		sendkeyToElement(driver, UserPageUI.DYNAMIC_TEXTBOX, email, "email_address");

		waitForElementVisible(driver, UserPageUI.DYNAMIC_TEXTBOX, "password");
		sendkeyToElement(driver, UserPageUI.DYNAMIC_TEXTBOX, password, "password");

		waitForElementVisible(driver, UserPageUI.DYNAMIC_TEXTBOX, "confirmation");
		sendkeyToElement(driver, UserPageUI.DYNAMIC_TEXTBOX, password, "confirmation");

		waitForElementClickable(driver, UserPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserPageUI.REGISTER_BUTTON);
	}

	public boolean isDisplayRegisterSuccessLabel() {
		waitForElementVisible(driver, UserPageUI.REGISTER_SUCCESS_LABEL);
		return elementIsDisplayed(driver, UserPageUI.REGISTER_SUCCESS_LABEL);
	}

	public AdminPageObject getAdminPage(WebDriver driver2) {
		openPageUrl(driver2, GlobalConstants.ADMIN_LIVE_GURU_URL_LINK);
		return PageGeneratorManager.getAdminPage(driver2);
	}

}

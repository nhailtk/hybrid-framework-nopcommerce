package com.jquery.pageObjects;

import org.openqa.selenium.WebDriver;

import com.jquery.pageUIs.AdminPageUI;

import common.BasePage;

public class AdminPageObject extends BasePage {
	WebDriver driver;

	public AdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void loginAdminPage(String userNameInAdminPage, String passwordInAminPage) {
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_TEXTBOX, "username");
		sendkeyToElement(driver, AdminPageUI.DYNAMIC_TEXTBOX, userNameInAdminPage, "username");
		
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_TEXTBOX, "login");
		sendkeyToElement(driver, AdminPageUI.DYNAMIC_TEXTBOX, passwordInAminPage, "login");
		
		waitForElementClickable(driver, AdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminPageUI.LOGIN_BUTTON);
		
	}

	public void searchUser(String fullName, String email) {
		if(isDisplayMessagePopup()) {
			waitForElementClickable(driver, AdminPageUI.CLOSE_BUTTON_IN_MESSAGE_POPUP);
			clickToElement(driver, AdminPageUI.CLOSE_BUTTON_IN_MESSAGE_POPUP);
		}
		
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_FILTER_TEXTBOX, "customerGrid_filter_name");
		sendkeyToElement(driver, AdminPageUI.DYNAMIC_FILTER_TEXTBOX, fullName, "customerGrid_filter_name");
		
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_FILTER_TEXTBOX, "customerGrid_filter_email");
		sendkeyToElement(driver, AdminPageUI.DYNAMIC_FILTER_TEXTBOX, email, "customerGrid_filter_email");
		
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_FILTER_TEXTBOX, "customerGrid_filter_Telephone");
		sendkeyToElement(driver, AdminPageUI.DYNAMIC_FILTER_TEXTBOX, "", "customerGrid_filter_Telephone");
		
		waitForElementClickable(driver, AdminPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
		
	}
	
	private boolean isDisplayMessagePopup() {
		waitForElementVisible(driver, AdminPageUI.MESSAGE_POPUP);
		return elementIsDisplayed(driver, AdminPageUI.MESSAGE_POPUP);
	}

	public boolean isDisplayNameAndEmailOfUser(String fullName, String email) {
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_RESULT, fullName);
		waitForElementVisible(driver, AdminPageUI.DYNAMIC_RESULT, email);
		return (elementIsDisplayed(driver, AdminPageUI.DYNAMIC_RESULT, fullName)& elementIsDisplayed(driver, AdminPageUI.DYNAMIC_RESULT, email));
	}

}

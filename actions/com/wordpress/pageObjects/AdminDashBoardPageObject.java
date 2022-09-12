package com.wordpress.pageObjects;

import org.openqa.selenium.WebDriver;

import com.wordpress.pageUIs.AdminDashboardPageUI;

import common.BasePage;

public class AdminDashBoardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPageObject clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getPostSearchPage(driver);
		
	}

}

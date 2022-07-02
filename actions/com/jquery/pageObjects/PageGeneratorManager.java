package com.jquery.pageObjects;

import org.openqa.selenium.WebDriver;

import demo.nopcommerce.com.pageObjects.admin.AdminDashBoardPageObject;
import demo.nopcommerce.com.pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static UserPageObject getUserPage(WebDriver driver) {
		return new UserPageObject(driver);
	}
	public static AdminPageObject getAdminPage(WebDriver driver) {
		return new AdminPageObject(driver);
	}

}


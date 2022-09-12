package com.wordpress.pageObjects;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	public static AdminLoginPageObject getLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashBoardPageObject getDashboardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
	
	public static AdminPostSearchPageObject getPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPageObject(driver);
	}
	
	public static AdminPostAddNewPageObject getPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPageObject(driver);
	}
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserPostDetailPageObject getPostDetailPage(WebDriver driver) {
		return new UserPostDetailPageObject(driver);
	}
	

}

package com.wordpress.pageObjects;

import org.openqa.selenium.WebDriver;

import com.wordpress.pageUIs.UserHomePageUI;

import common.BasePage;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserPostDetailPageObject clickToTitlePost() {
		waitForElementClickable(driver, UserHomePageUI.USER_POST_TITLE);
		clickToElement(driver, UserHomePageUI.USER_POST_TITLE);
		return PageGeneratorManager.getPostDetailPage(driver);
	}

	public boolean isPostInforDisplayedWithPostBody(String postBody) {
		waitForElementVisible(driver, UserHomePageUI.USER_POST_BODY,postBody);
		return elementIsDisplayed(driver, UserHomePageUI.USER_POST_BODY, postBody);

	}

	public boolean isPostInforDisplayedWithPostAuthor(String postTitle, String authorNameInEndUser) {
		waitForElementVisible(driver, UserHomePageUI.USER_POST_AUTHOR_BY_POST_TITLE, postTitle, authorNameInEndUser);
		return elementIsDisplayed(driver, UserHomePageUI.USER_POST_AUTHOR_BY_POST_TITLE, postTitle, authorNameInEndUser);

	}

	public boolean isPostInforDisplayedWithPostTime(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.USER_POST_TIME_BY_POST_TITLE, postTitle, currentDay);
		return elementIsDisplayed(driver, UserHomePageUI.USER_POST_TIME_BY_POST_TITLE, postTitle, currentDay);

	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.USER_POST_TITLE, postTitle);
		return elementIsDisplayed(driver, UserHomePageUI.USER_POST_TITLE, postTitle);
	}

}

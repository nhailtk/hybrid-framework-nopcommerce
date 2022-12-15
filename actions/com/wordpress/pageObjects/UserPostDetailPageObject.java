package com.wordpress.pageObjects;

import org.openqa.selenium.WebDriver;

import com.wordpress.pageUIs.UserHomePageUI;
import com.wordpress.pageUIs.UserPostDetailPageUI;

import common.BasePage;

public class UserPostDetailPageObject extends BasePage {
	WebDriver driver;

	public UserPostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void isPostInforDisplayed(String postTitle) {
		// TODO Auto-generated method stub

	}

	public boolean isPostInforDisplayedWithPostBody(String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_DETAIL_BODY, postBody);
		return elementIsDisplayed(driver, UserPostDetailPageUI.USER_POST_DETAIL_BODY, postBody);

	}

	public boolean isPostInforDisplayedWithPostAuthor(String postTitle, String authorNameInEndUser) {
		waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_DETAIL_AUTHOR_BY_POST_TITLE, postTitle, authorNameInEndUser);
		return elementIsDisplayed(driver, UserPostDetailPageUI.USER_POST_DETAIL_AUTHOR_BY_POST_TITLE, postTitle, authorNameInEndUser);

	}

	public boolean isPostInforDisplayedWithPostTime(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_DETAIL_TIME_BY_POST_TITLE, postTitle, currentDay);
		return elementIsDisplayed(driver, UserPostDetailPageUI.USER_POST_DETAIL_TIME_BY_POST_TITLE, postTitle, currentDay);

	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_DETAIL_TITLE, postTitle);
		return elementIsDisplayed(driver, UserPostDetailPageUI.USER_POST_DETAIL_TITLE, postTitle);
	}



}
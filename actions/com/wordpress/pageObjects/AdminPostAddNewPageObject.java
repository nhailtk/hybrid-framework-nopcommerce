package com.wordpress.pageObjects;

import org.openqa.selenium.WebDriver;

import com.wordpress.pageUIs.AdminPostAddNewPageUI;

import common.BasePage;

public class AdminPostAddNewPageObject extends BasePage{
	WebDriver driver;

	public AdminPostAddNewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToPostTitleTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX, postTitle);
		
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		
	}

	public boolean isDisplayedPostPublishMessage() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE);
		return elementIsDisplayed(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE);
	}

	public void inputToPostBodyTextbox(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFORE_CLICK);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFORE_CLICK);
		
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_AFTER_CLICK);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_AFTER_CLICK, postBody);
		
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		
	}

	public AdminPostSearchPageObject openSearchPostPage(WebDriver driver2, String postSearchPageURL) {
		openPageUrl(driver2, postSearchPageURL);
		return PageGeneratorManager.getPostSearchPage(driver2);
	}
	
}

package com.wordpress.pageUIs;

public class AdminPostAddNewPageUI {
	public static final String POST_TITLE_TEXTBOX = "XPATH=//h1[contains(@class,'block editor-post-title')]";
	public static final String POST_BODY_TEXTBOX_BEFORE_CLICK = "XPATH=//p[contains(@class,'block-editor-default-block-appender')]";
	public static final String POST_BODY_TEXTBOX_AFTER_CLICK = "XPATH=//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String PUBLISH_BUTTON = "XPATH=//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']";
	public static final String PRE_PUBLISH_BUTTON = "XPATH=//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']";
	public static final String POST_PUBLISHED_MESSAGE = "XPATH=//div[@class='components-snackbar']/div[contains(text(),'Post published.')]";

}

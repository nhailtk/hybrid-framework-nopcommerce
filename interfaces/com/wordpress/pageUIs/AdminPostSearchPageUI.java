package com.wordpress.pageUIs;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "XPATH=//h1[contains(text(),'Posts')]/following-sibling::a";
	public static final String SEARCH_POST_TEXTBOX = "XPATH=//input[@id='post-search-input']";
	public static final String SEARCH_POST_BUTTON = "XPATH=//input[@id='search-submit']";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "Xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "Xpath=//table[contains(@class,'table-view-list posts')]/tbody//tr/*[%s]";
	public static final String TITLE_VALUE_IN_ROW= "Xpath=//table[contains(@class,'table-view-list posts')]/tbody//tr//a[@class='row-title' and text()='%s']";

}

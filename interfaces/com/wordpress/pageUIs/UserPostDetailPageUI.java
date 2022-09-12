package com.wordpress.pageUIs;

public class UserPostDetailPageUI {
	public static final String USER_POST_DETAIL_TITLE = "XPATH=//article//h1[contains(text(),'%s')]";
	public static final String USER_POST_DETAIL_TIME_BY_POST_TITLE = "XPATH=//article//h1[contains(text(),'%s')]/following-sibling::div//time[contains(text(),'%s')]";
	public static final String USER_POST_DETAIL_AUTHOR_BY_POST_TITLE = "XPATH=//article//h1[contains(text(),'%s')]/following-sibling::div//a[contains(text(),'%s')]";
	public static final String USER_POST_DETAIL_BODY = "XPATH=//article//p[text()='%s']";
}

package com.wordpress.pageUIs;

public class UserHomePageUI {
	public static final String USER_POST_TITLE = "XPATH=//article//h2/a[contains(text(),'%s')]";
	public static final String USER_POST_BODY = "XPATH=//article//p[contains(text(),'%s')]";
	public static final String USER_POST_TIME_BY_POST_TITLE = "XPATH=//article//a[contains(text(),'%s')]/parent::h2/following-sibling::div//time[contains(text(),'%s')]";
	public static final String USER_POST_AUTHOR_BY_POST_TITLE = "XPATH=//article//a[contains(text(),'%s')]/parent::h2/following-sibling::div//aa[contains(text(),'%s')]";

}

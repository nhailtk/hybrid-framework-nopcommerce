package com.jquery.pageUIs;

public class HomePageUI {
	public static final String PAGING_BY_NUMBER ="XPATH=//li[@class='qgrd-pagination-page']/a[contains(text(),'%s')]";
	public static final String HEADER_TEXTBOX_BY_LABEL ="xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGE ="XPATH=//ul[@class='qgrd-pagination-ul']/li";
	public static final String ALL_ROW_IN_EACH_PAGE ="XPATH=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_IN_EACH_PAGE ="XPATH=//tbody/tr/td[@data-key='country']";
	public static final String PAGE_ACTIVE_BY_NUMBER ="XPATH=//li[@class='qgrd-pagination-page']/a[contains(text(),'%s') and @class = 'qgrd-pagination-page-link active']";
	
	
	public static final String COLUMN_INDEX_BY_NAME ="XPATH=//td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER="XPATH=//tbody/tr[%s]/td[%s]/input";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER="XPATH=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_NUMBER="XPATH=//tbody/tr[%s]/td[%s]/select";
	public static final String BUTTON_BY_ROW_NUMBER="XPATH=//tr[%s]//button[@title='%s']";
	
	public static final String LOAD_DATA_BUTTON="XPATH=//button[@id='btnLoad']";

}

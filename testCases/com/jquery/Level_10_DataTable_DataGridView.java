package com.jquery;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jquery.pageObjects.HomePageObject;
import com.jquery.pageObjects.PageGeneratorManager;

import common.BaseTest;

public class Level_10_DataTable_DataGridView extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private List<String> actualCountryValues;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName,appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	public void Talbe_01_Paging() {
		homePage.openPageByPageNumber("2");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isDisplayPageActive("2"));
		
		
		homePage.openPageByPageNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isDisplayPageActive("5"));
		
		
		homePage.openPageByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isDisplayPageActive("10"));
	
	}

	
	public void Table_02_InputDataToHeader() {
		homePage.refreshCurrentPage(driver);
		homePage.inputDataToHeaderByLabel("Females","276880");
		homePage.inputDataToHeaderByLabel("Country","Angola");
		homePage.inputDataToHeaderByLabel("Males","276472");
		homePage.inputDataToHeaderByLabel("Total","553353");
		homePage.sleepInSecond(1);

		homePage.inputDataToHeaderByLabel("Females","15999");
		homePage.inputDataToHeaderByLabel("Country","Armenia");
		homePage.inputDataToHeaderByLabel("Males","16456");
		homePage.inputDataToHeaderByLabel("Total","32487");

	}


	
	public void Table_03_GetAllData() {
		actualCountryValues = homePage.getEachRowAtAllPage();
	}

	@Test
	public void Table_04_Enter_To_Textbox_Any_Row() {
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(1);
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Album","1","Number_1");
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist","2","Acoutics_11");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year","3","2022");
		homePage.enterToTextboxByColumnNameAtRowNumber("Price","4","$200");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","5","Japan");
		homePage.sleepInSecond(1);
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","5","Korea");
		homePage.sleepInSecond(1);
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?","3");
		homePage.sleepInSecond(1);
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?","1");
		homePage.sleepInSecond(1);
		
		homePage.clickToRemoveButtonByRowNumber("1","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToRemoveButtonByRowNumber("1","Insert Row Above");
		homePage.sleepInSecond(1);
		homePage.clickToRemoveButtonByRowNumber("3","Move Up");
		homePage.sleepInSecond(1);
		homePage.clickToRemoveButtonByRowNumber("3","Move Down");
		homePage.sleepInSecond(1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

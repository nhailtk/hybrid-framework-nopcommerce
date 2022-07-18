package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jquery.pageObjects.HomePageObject;
import com.jquery.pageObjects.PageGeneratorManager;

import common.BaseTest;

public class Level_11_Upload_Files extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	String fileName1 ="HaiDuong.jpg";
	String fileName2 ="HaNoi.jpg";
	String[] multipleFileName = {"HaiDuong.jpg","HaNoi.jpg"};
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName,appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, fileName1);
		Assert.assertTrue(homePage.isDisplayFileNameLoaded(fileName1));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isDisplayFileNameUploaded(fileName1));
		Assert.assertTrue(homePage.isDisplayImageUploaded(fileName1));
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileName);
		Assert.assertTrue(homePage.isDisplayFileNameLoaded(fileName1));
		Assert.assertTrue(homePage.isDisplayFileNameLoaded(fileName2));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isDisplayFileNameUploaded(fileName1));
		Assert.assertTrue(homePage.isDisplayFileNameUploaded(fileName2));
		Assert.assertTrue(homePage.isDisplayImageUploaded(fileName1));
		Assert.assertTrue(homePage.isDisplayImageUploaded(fileName2));
		
	}
		
		
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

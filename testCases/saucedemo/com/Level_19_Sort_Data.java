package saucedemo.com;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import saucedemo.com.pageObjects.HomePageObject;
import saucedemo.com.pageObjects.LoginPageObject;
import saucedemo.com.pageObjects.PageGeneratorManager;

public class Level_19_Sort_Data extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String standard_user = "standard_user", password = "secret_sauce";
	private HomePageObject homePage;
	private LoginPageObject loginPage;


	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		homePage = loginPage.clickToLoginButton(standard_user,password);
		Assert.assertTrue(homePage.isDisplayedMenuButton());
		
	}

	@Test
	public void TC_01_Sort_With_Name_ASC() {
		homePage.clickToSortDropdown("Name (A to Z)");
		Assert.assertTrue(homePage.isDisplayedSortWithNameASC());
	}

	@Test
	public void TC_02_Sort_With_Name_DESC() {
		homePage.clickToSortDropdown("Name (Z to A)");
		Assert.assertTrue(homePage.isDisplayedSortWithNameDESC());

	}

	@Test
	public void TC_03_Sort_With_Price_ASC() {
		homePage.clickToSortDropdown("Price (low to high)");
		Assert.assertTrue(homePage.isDisplayedSortWithPriceASC());
	}
	
	@Test
	public void TC_04_Sort_With_Price_DESC() {
		homePage.clickToSortDropdown("Price (high to low)");
		Assert.assertTrue(homePage.isDisplayedSortWithPriceDESC());
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}

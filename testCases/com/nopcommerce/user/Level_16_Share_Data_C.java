package com.nopcommerce.user;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

import common.BaseTest;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;

public class Level_16_Share_Data_C extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String validEmail, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		validEmail = Common_01_Register_End_User.validEmail;
		password = Common_01_Register_End_User.password;
		
		log.info("Pre-Condition - step 1 - click to 'Login' link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-Condition - step 2 - Set cookie and reload page");
		loginPage.setCookie(driver, Common_01_Register_Cookie.loggedCookies);
		loginPage.refreshCurrentPage(driver);
		
		log.info("Pre-Condition - step 5 - verify My Account Link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_01_Search_With_Invalid_Data() {

	}

	@Test
	public void TC_02_Search_With_Valid_Data() {

	}

	public int randomEmailByNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}

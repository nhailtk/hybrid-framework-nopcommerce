package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import common.BaseTest;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;

public class Level_18_Pattern_Object extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String validEmail;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	String firstName = "Automation", lastName = "FC", password = "123456";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		validEmail = "automation" + randomEmailByNumber() + "@gmail.com";

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToTextboxById(driver, "FirstName", firstName);
		registerPage.inputToTextboxById(driver, "LastName", lastName);
		registerPage.inputToTextboxById(driver, "Email", validEmail);
		registerPage.inputToTextboxById(driver, "Password", password);
		registerPage.inputToTextboxById(driver, "ConfirmPassword", password);

		
		registerPage.clickToButtonByName(driver,"Register");
		Assert.assertEquals(registerPage.getSuccessMessageRegister(), "Your registration completed");

		Assert.assertTrue(homePage.verifyElementIsDisplayed());

		homePage = registerPage.clickToLogOutUserLink(driver);
	}

	@Test
	public void TC_01_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToTextboxById(driver, "Email", validEmail);
		loginPage.inputToTextboxById(driver, "Password", password);

		loginPage.clickToButtonByName(driver,"Log in");
		homePage = loginPage.getUserHomePage();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_02_Search_With_Valid_Data() {

	}

	public int randomEmailByNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}

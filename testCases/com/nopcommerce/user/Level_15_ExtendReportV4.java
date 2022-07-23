package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;

public class Level_15_ExtendReportV4 extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String validEmail, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	String firstName = "Automation", lastName = "FC", password = "123456";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);

		validEmail = "automation" + randomEmailByNumber() + "@gmail.com";
		notFoundEmail = "automation" + randomEmailByNumber() + "@abc.com";
		invalidEmail = "abc@123#456";

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_User_01_Register(Method method) {

		registerPage = homePage.clickToRegisterLink();


		registerPage.inputToFirstNameTextbox(firstName);


		registerPage.inputToLastNameTextbox(lastName);

		
		registerPage.inputToEmailTextbox(validEmail);

		
		registerPage.inputToPasswordTextbox(password);

		
		registerPage.inputToConfirmPasswordTextbox(password);

		
		registerPage.clickToRegisterButton();

		
		Assert.assertEquals(registerPage.getSuccessMessageRegister(), "Your registration completed");

		
		Assert.assertTrue(homePage.verifyElementIsDisplayed());

	}

	@Test
	public void TC_User_02_Login(Method method) {
		
		homePage = registerPage.clickToLogOutUserLink(driver);
		
		
		loginPage = homePage.clickToLoginLink();
		
		
		loginPage.inputToEmailTextbox(validEmail);
		
		
		loginPage.inputToPasswordTextbox(password);

		
		homePage = loginPage.clickToLoginButton();
		
		
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

	}

	public int randomEmailByNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

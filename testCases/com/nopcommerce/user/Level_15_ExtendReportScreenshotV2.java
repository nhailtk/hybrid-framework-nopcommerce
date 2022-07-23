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


public class Level_15_ExtendReportScreenshotV2 extends BaseTest {
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
//		ExtentManager.startTest(method.getName(), "TC_User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 1 - click to 'Register' link");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 2 - input value into ' First name' textbox: " + firstName);
//		registerPage.inputToFirstNameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 3 - input value into 'Last name' textbox: " + lastName);
//		registerPage.inputToLastNameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 4 - input value into 'Email' textbox: " + validEmail);
//		registerPage.inputToEmailTextbox(validEmail);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 5 - input value into 'Password' textbox: " + password);
//		registerPage.inputToPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 6 - input value into 'Confirm password' textbox: " + password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 7 - click to 'Register' button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 8 - verify customer info");
//		Assert.assertEquals(registerPage.getSuccessMessageRegister(), "Your rigistration completed");
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - step 9 - check undisplayed");
//		Assert.assertTrue(homePage.verifyElementIsDisplayed());
//		ExtentManager.endTest();

	}

	@Test
	public void TC_User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "TC_User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - step 1 - click to 'Logout' link");
//		homePage = registerPage.clickToLogOutUserLink(driver);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - step 1 - click to 'Login' link");
//		loginPage = homePage.clickToLoginLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - step 2 - input value into 'Email' textbox: " + validEmail);
//		loginPage.inputToEmailTextbox(validEmail);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - step 3 - input value into 'Password' textbox: " + password);
//		loginPage.inputToPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - step 4 - click to 'Login' button");
//		homePage = loginPage.clickToLoginButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - step 5 - verify My Account Link displayed");
//		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
//		ExtentManager.endTest();

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

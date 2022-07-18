package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;

public class Level_14_Log_ReportNG extends BaseTest {
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
	public void TC_User_01_Register() {
		log.info("Register - step 1 - click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - step 2 - input value into ' First name' textbox: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Register - step 3 - input value into 'Last name' textbox: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - step 4 - input value into 'Email' textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);

		log.info("Register - step 5 - input value into 'Password' textbox: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - step 6 - input value into 'Confirm password' textbox: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - step 7 - click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Register - step 8 - verify customer info");
		verifyEquals(registerPage.getSuccessMessageRegister(), "Your registration completed");

		log.info("Register - step 9 - check undisplayed");
		verifyTrue(homePage.verifyElementIsDisplayed());

		log.info("Register - step 9 - logout system");
		homePage = registerPage.clickToLogOutUserLink(driver);
	}

	public void TC_User_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isMyAccountLinkDisplayed());

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

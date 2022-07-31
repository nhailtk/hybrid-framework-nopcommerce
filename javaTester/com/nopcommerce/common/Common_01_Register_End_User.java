package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String  firstName, lastName;
	public static String validEmail, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Create new common user for all classes test ")
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		validEmail = "automation" + randomEmailByNumber() + "@gmail.com";
		password = "123456";
		firstName = "Automation";
		lastName = "FC";
		
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
		driver.quit();
		
	}

	public int randomEmailByNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}

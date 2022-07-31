package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;

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

public class Level_16_Share_Data_B extends BaseTest {
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
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		validEmail = "automation" + randomEmailByNumber() + "@gmail.com";
		
		
		log.info("Pre-Condition - step 1 - click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition - step 2 - input value into ' First name' textbox: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Pre-Condition - step 3 - input value into 'Last name' textbox: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Pre-Condition - step 4 - input value into 'Email' textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);

		log.info("Pre-Condition - step 5 - input value into 'Password' textbox: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - step 6 - input value into 'Confirm password' textbox: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition - step 7 - click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - step 8 - verify customer info");
		verifyEquals(registerPage.getSuccessMessageRegister(), "Your rigistration completed");

		log.info("Pre-Condition - step 9 - check undisplayed");
		verifyTrue(homePage.verifyElementIsDisplayed());

		log.info("Pre-Condition - step 10 - logout system");
		homePage = registerPage.clickToLogOutUserLink(driver);
		
		log.info("Pre-Condition - step 11 - click to 'Login' link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-Condition - step 12 - input value into 'Email' textbox: " + validEmail);
		loginPage.inputToEmailTextbox(validEmail);
		
		log.info("Pre-Condition - step 13 - input value into 'Password' textbox: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - step 14 - click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-Condition - step 15 - verify My Account Link displayed");
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
		driver.quit();
	}
}

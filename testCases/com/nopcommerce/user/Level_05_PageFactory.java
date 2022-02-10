package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.RegisterPageObject;

public class Level_05_PageFactory extends BaseTest {
	private WebDriver driver;
	private String emailAddress;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String firstName = "Automation", lastName = "FC", password = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getWebDriver(browserName);
		homePage = new HomePageObject(driver);
		emailAddress = "automation" + randomEmailByNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.registergetErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123#$%");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageWrongEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		
		Assert.assertEquals(registerPage.getSuccessMessageRegister(),"Your registration completed");


		registerPage.clickToLogOutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageExistingEmail(),"The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.registergetErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.registergetErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
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

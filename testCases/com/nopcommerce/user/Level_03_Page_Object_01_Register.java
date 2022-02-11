package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.server.HomeBaseWarning;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;

public class Level_03_Page_Object_01_Register  {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	UserHomePageObject homePage ;
	UserRegisterPageObject registerPage;
	String firstName = "Automation", lastName = "FC", password = "123456";
	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		homePage = new UserHomePageObject(driver);
		
		emailAddress = "automation" + randomEmailByNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePage.clickToRegisterLink();

		registerPage = new UserRegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.registergetErrorMessageAtFirstNameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtLastNameTextbox(),"Last name is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtEmailTextbox(),"Email is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.registergetErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
		
	}



	@Test
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123#$%");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);


		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageWrongEmail(),"Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		
		Assert.assertEquals(registerPage.getSuccessMessageRegister(),"Your registration completed");


		registerPage.clickToLogOutUserLink(driver);
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

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
		
		registerPage = new UserRegisterPageObject(driver);

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
		
		registerPage = new UserRegisterPageObject(driver);

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

package facebook.com;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import facebook.com.pageObjects.HomePageObject;
import facebook.com.pageObjects.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	private HomePageObject homePage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Element_Displayed_Undisplayed() {
		//Hien thi va co trong DOM -> pass
		verifyTrue(homePage.elementIsDisplayed());
		
		homePage.clickToRegisterButton();
		
		//element khong hien thi va khong co trong DOM -> pass
		verifyTrue(homePage.elementIsUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

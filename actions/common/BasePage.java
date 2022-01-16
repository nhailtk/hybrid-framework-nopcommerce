package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowById(WebDriver driver, String pageId) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(pageId)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public void switchToWindowByTitlePage(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			String actualTitle = driver.getTitle().trim();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeTabWithoutParentPage(WebDriver driver, String parentPageId) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentPageId)) {
				driver.switchTo().window(window);
				driver.close();
			}
			driver.switchTo().window(parentPageId);
		}

	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	private WebElement getElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getElement(driver, xpathLocator).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}

	public String getFirstItemInDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInCustomerDropdown(WebDriver driver, String parentXpath, String childXpath, String itemSelect) {
		getElement(driver, parentXpath).click();
		WebDriverWait explicitlyWait = new WebDriverWait(driver, longTimeOut);

		List<WebElement> listItem = explicitlyWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		for (WebElement item : listItem) {
			if (item.getText().trim().equals(itemSelect)) {
				if (item.isDisplayed()) {
					item.click();
				} else {
					JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
					jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);
					item.click();
				}
				break;
			}
		}
	}

	public void sleepInSecond(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).getText();
	}

	public String getElemenCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String convertRgbaToHex(String rgvaValue) {
		return Color.fromString(rgvaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	
	public void checktoDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}	
	}
	
	public void unchecktoDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}	
	}
	
	public boolean elementIsDisplayed(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean elementIsEnabled(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean elementIsSelected(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) { 
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, xpathLocator)).perform();
	}
	

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathLocator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	private long longTimeOut = 30;
	
}

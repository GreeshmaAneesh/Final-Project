package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility{
	public void dragAnddrop(WebElement dragableItem, WebElement dropItem, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(dragableItem).moveToElement(dropItem).release(dropItem).build().perform();
	}

	public void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectDropdownbyValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}
	public void selectDropdownbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void acceptAlert(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().dismiss();
	}
	
	public void promptAlert(WebElement element, WebDriver driver,String text) {
			element.click();
			driver.switchTo().alert().sendKeys(text);
			driver.switchTo().alert().accept();
	}
	public void clickByJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void scrollByJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	public void doubleClick(WebElement dragableItem, WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.doubleClick(dragableItem).perform();
	}
	public void rightClick(WebElement dragableItem, WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.contextClick(dragableItem);
	}
	public void getAttributes(WebElement element, String attribute) {
		element.getAttribute(attribute);
	}
	public void getCssValue(WebElement element, String CssValue) {
		element.getCssValue(CssValue);
	}
}


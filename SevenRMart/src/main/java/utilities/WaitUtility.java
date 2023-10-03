package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static final long FLUENT_WAIT = 20;
	public static final long POLL_WAIT = 3;
	
	public void implicitWait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}

	public void waitForVisibilityOfElement(WebDriver driver, WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}

	public void waitForVisibilityOfElementLocated(WebDriver driver, By target)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(target));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public void waitForAlertIsPresent(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void fluentWaitForVisibilityOfElementLocated(WebDriver driver, By target) 
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLL_WAIT))
				.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(target));
	}
	public void fluentWaitForVisibilityOfElement(WebDriver driver, WebElement target) 
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLL_WAIT))
				.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOf(target));
	}
	public void fluentWaitForElementToBeClickable(WebDriver driver, WebElement target) 
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLL_WAIT))
				.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public void fluentWaitForAlertIsPresent(WebDriver driver) 
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLL_WAIT))
				.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
				
}

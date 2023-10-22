package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class LoginPage 
{
	public WebDriver driver;
	public WaitUtility waitutility;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text']") private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']") private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") private WebElement signInButton;
	@FindBy(xpath="//a[text()='Home']") private WebElement homeText;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]") private WebElement alertMessage;
	public LoginPage enterUserNameOnUserNameField(String username)
	{
		usernameField.sendKeys(username);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public LoginPage clickOnSignInButton()
	{
		signInButton.click();
		return this;
	}
	public String getHomeText()
	{
		
		return homeText.getText();
	}
	public boolean alertMessage()
	{
		boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
	}

}

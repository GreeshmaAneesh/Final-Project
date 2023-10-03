package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class PushNotificationPage {
	public WebDriver driver;
	public PushNotificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath=("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']"))private WebElement pushNotificationButton;
@FindBy(xpath=("//input[@id='title']"))	private WebElement titleField;
@FindBy(xpath=("//input[@id='description']"))	private WebElement descriptionField;
@FindBy(xpath=("//button[@type='submit']"))private WebElement sendButton;
@FindBy(xpath=("//div[contains(@class,'alert')]"))private WebElement alertMessage;
public PushNotificationPage clickOnPushNotificationsButton()
{
	WaitUtility waitutility=new WaitUtility();
	waitutility.waitForElementToBeClickable(driver, pushNotificationButton);
	pushNotificationButton.click();	
	return this;
}
public PushNotificationPage enterTitleOnTitleField(String title)
{
	titleField.sendKeys(title);
	return this;

}
public PushNotificationPage enterDescriptionOnDescriptionField(String description)
{
	descriptionField.sendKeys(description);
	return this;

}
public PushNotificationPage clickOnSendButton()
{
	sendButton.click();
	return this;

}
public boolean IsAlertMessageDisplayed()
{
	
	boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
	return isAlertMessageDisplayed;
}
	
}

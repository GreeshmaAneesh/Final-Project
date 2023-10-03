package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AddNewUserPage {
	public WebDriver driver;
	public WaitUtility waitutility;
	public PageUtility pageutility;
	public AddNewUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath=("//div[@class='icon']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']"))private WebElement adminusers;
@FindBy(xpath = ("//a[@onclick='click_button(1)']")) private WebElement newButton;
@FindBy(xpath=("//input[@id='username']"))private WebElement usernameField;
@FindBy(xpath=("//input[@id='password']"))private WebElement passwordField;
@FindBy(xpath=("//select[@id='user_type']"))private WebElement userTypeField;
@FindBy(xpath = ("//button[@name='Create']"))private WebElement saveButton;
@FindBy(xpath = ("//div[contains(@class,'alert-success')]"))private WebElement alertMessage;

public AddNewUserPage clickOnAdminUser()
{
	waitutility=new WaitUtility();
	waitutility.waitForElementToBeClickable(driver, adminusers);
	adminusers.click();
	return this;
}
public AddNewUserPage clickOnNewButton()
{
	newButton.click();
	return this;

}
public AddNewUserPage enterUsernameField(String usernameOfAdmin)
{
	usernameField.sendKeys(usernameOfAdmin);
	return this;

}
public AddNewUserPage enterpasswordField(String passwordOfAdmin)
{
	passwordField.sendKeys(passwordOfAdmin);
	return this;

}
public AddNewUserPage enterUserType(String userTypeOfAdmin)
{
	pageutility=new PageUtility();
	pageutility.selectDropdownbyText(userTypeField, userTypeOfAdmin);
	userTypeField.sendKeys(userTypeOfAdmin);
	return this;

}
public AddNewUserPage clickOnSaveButton()
{
	saveButton.click();
	return this;

}
public boolean alertMessageIsDisplayed()
{
	waitutility=new WaitUtility();
	waitutility.waitForVisibilityOfElement(driver, alertMessage);
	boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
	return isAlertMessageDisplayed;
}
}

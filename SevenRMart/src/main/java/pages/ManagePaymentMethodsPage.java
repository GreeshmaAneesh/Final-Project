package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePaymentMethodsPage {
	public WebDriver driver;
	public WaitUtility waitutility;
	public PageUtility pageutility;
	public ManagePaymentMethodsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-payment-methods']//following::p[text()='Manage Payment Methods']"))private WebElement managepaymentbutton;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-payment-methods?edit=2&page_ad=1']"))private WebElement editButton;
	@FindBy(xpath=("//input[@id='name']"))private WebElement titleField;
	@FindBy(xpath=("//button[@name='Update']"))private WebElement updateButton;
	@FindBy(xpath=("//div[contains(@class,'alert-success')]"))private WebElement alertMessage;
	
	public ManagePaymentMethodsPage clickOnManagePaymentMethods()
	{
		managepaymentbutton.click();
		return this;
	}
	public ManagePaymentMethodsPage clickOnEditButton()
	{
		editButton.click();
		return this;

	}
	public ManagePaymentMethodsPage enterTheUpdatedTitle(String updatedTitle)
	{
		titleField.sendKeys(updatedTitle);
		return this;

	}
	public ManagePaymentMethodsPage clickOnUpdateButton()
	{
		updateButton.click();
		return this;

	}
	public boolean isAlertMessageDisplayed()
	{
		boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
		
	}

}

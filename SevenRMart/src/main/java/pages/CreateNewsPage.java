package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class CreateNewsPage {
	
	public WebDriver driver;
	public WaitUtility waitutility;
	public PageUtility pageutility;
	public CreateNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=("//li[@class='nav-item']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']"))private WebElement manageNews;
	@FindBy(xpath = ("//a[@onclick='click_button(1)']"))private WebElement newButton;
	@FindBy(xpath=("//textarea[@id='news']"))private WebElement textField;
	@FindBy(xpath = ("//button[@name='create']"))private WebElement saveButton;
	@FindBy(xpath = ("//div[contains(@class,'alert-success')]"))private WebElement alertMessage;
	@FindBy(xpath = ("//div[@class='card-header']//following::td[text()='Hello']"))private WebElement manageNewsTable;
public CreateNewsPage clickOnManageNews()
{
	pageutility=new PageUtility();
	pageutility.clickByJavaScriptExecutor(manageNews, driver);
	return this;
}
public CreateNewsPage clickOnNewButton()
{
	WaitUtility waitutility=new WaitUtility();
	waitutility.waitForVisibilityOfElement(driver, newButton);
	pageutility=new PageUtility();
	pageutility.clickByJavaScriptExecutor(newButton, driver);
	return this;
}
public CreateNewsPage enterTheTextInNewsField(String newsText)
{
	textField.sendKeys(newsText);
	return this;
}
public CreateNewsPage clickOnSaveButton()
{
	saveButton.click();
	return this;
}
public boolean isAlertMessageDisplayed()
{
	boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
	return isAlertMessageDisplayed;
}
}

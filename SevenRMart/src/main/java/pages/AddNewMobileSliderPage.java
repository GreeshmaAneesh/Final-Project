package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AddNewMobileSliderPage {
	public WebDriver driver;
	public WaitUtility waitutility;
	public FileUploadUtility fileuploadutility;
	public PageUtility pageutility;
	
	public AddNewMobileSliderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath=("//nav[@class='mt-2']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']"))private WebElement mobileSliderMenu;
@FindBy(xpath=("//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/add']"))private WebElement addButton;
@FindBy(xpath=("//select[@id='cat_id']"))private WebElement categoryField;
@FindBy(xpath=("//input[@type='file']"))private WebElement imageUploadButton;
@FindBy(name=("create"))private WebElement saveButton;
@FindBy(xpath=("//div[contains(@class,'alert')]"))private WebElement alertMessage;

public AddNewMobileSliderPage clickOnMobileSlidebarmenu()
{
	mobileSliderMenu.click();
	return this;
}
public AddNewMobileSliderPage clickOnAddButton()
{
	waitutility=new WaitUtility();
	waitutility.waitForVisibilityOfElement(driver, addButton);
	pageutility=new PageUtility();
	pageutility.clickByJavaScriptExecutor(addButton, driver);
	return this;
}
public AddNewMobileSliderPage selectCategory(String categoryName)
{
	categoryField.sendKeys(categoryName);
	return this;
}
public AddNewMobileSliderPage uploadImage()
{
	waitutility=new WaitUtility();
	waitutility.waitForVisibilityOfElement(driver, imageUploadButton);
	fileuploadutility=new FileUploadUtility();
	fileuploadutility.fileUploadUsingSendKeys(imageUploadButton,GeneralUtility.IMAGEFILEFORMOBILESLIDEBARPAGE);
	return this;
}
public AddNewMobileSliderPage clickOnSaveButton()
{
	saveButton.click();
	return this;
}
public boolean IsAlertMessageDisplayed()
{
	boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
	return isAlertMessageDisplayed;
}
}

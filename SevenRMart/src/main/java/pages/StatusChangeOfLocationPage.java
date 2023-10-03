package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class StatusChangeOfLocationPage {
	public WebDriver driver;
	public WaitUtility waitutility;
	public PageUtility pageutility;
	public StatusChangeOfLocationPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath=("//nav[@class='mt-2']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']"))private WebElement manageLocations;
@FindAll({@FindBy(xpath="//table[contains(@class,'table-hover')]//following::td[text()='Wonderland']")})private List<WebElement> Selectedlocation;
@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/status?id=1644&st=inactive&page_ad=1']"))private WebElement activeButton;
@FindBy(xpath = ("//div[contains(@class,'alert-success')]"))private WebElement alertMessage;
public StatusChangeOfLocationPage clickOnManageLocations()
{
	manageLocations.click();
	return this;
}
public StatusChangeOfLocationPage changeStatusOfSelectedLocation( String expectedLocation)
{
	for(WebElement locationList:Selectedlocation)
	{
		String getlocationList=locationList.getText();
		if(getlocationList.contains(expectedLocation))
		{
			pageutility =new PageUtility();
			pageutility.clickByJavaScriptExecutor(activeButton, driver);
			
		}
	}
	return this;
}
public StatusChangeOfLocationPage  clickOnActiveStatusButton()
{
	
	pageutility=new PageUtility();
	pageutility.clickByJavaScriptExecutor(activeButton, driver);
	return this;

}
public boolean alertMessageIsDisplayed()
{
	boolean isAlertMessageIsDisplayed=alertMessage.isDisplayed();
	return isAlertMessageIsDisplayed;
}
}
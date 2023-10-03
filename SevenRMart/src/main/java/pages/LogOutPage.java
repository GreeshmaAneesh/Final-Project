package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	public WebDriver driver;
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=("//a[@data-toggle='dropdown']"))private WebElement adminbutton;
	@FindBy(xpath = ("//div[contains(@class,'menu')]//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")) private WebElement logOutButton;
	@FindBy(xpath=("//div[@class='card']//following-sibling::p"))private WebElement signInText;
	
	public LogOutPage clickOnAdminButton()
	{
		adminbutton.click();
		return this;
	}
	public LogOutPage SelectLogoutButtonFromDropDown()
	{
		logOutButton.click();
		return this;

	}
	public boolean isSignInPageDisplayed()
	{
	boolean isSignInPageDisplayed=signInText.isDisplayed();
	return isSignInPageDisplayed;
	}

}

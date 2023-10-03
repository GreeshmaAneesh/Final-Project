package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderStatusPage 
{
	public WebDriver driver;
public OrderStatusPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath=("//div[@class='icon']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']"))private WebElement manageOrders;
@FindBy(xpath=("//a[@onclick='click_button(2)']"))private WebElement SearchButton;
@FindBy(xpath = ("//input[@id='od']"))private WebElement orderIdField;
@FindBy(xpath = ("//button[@name='Search']"))private WebElement SearchOrderButton;
@FindBy(xpath = ("//table[contains(@class,'table')]//following-sibling::span"))private WebElement listNotFoundMessage;
public OrderStatusPage clickOnManageOrders()
{
	manageOrders.click();
	return this;
}
public OrderStatusPage clickOnSearchButton() 
{
	SearchButton.click();
	return this;

}
public OrderStatusPage enterTheWrongOrderId(String orderId)
{
	orderIdField.sendKeys(orderId);
	return this;

}
public OrderStatusPage clickOnSearchOrderButton()
{
	SearchOrderButton.click();
	return this;

}
public boolean isResultNotFoundMessageDisplayed()
{
	boolean isResultNotFoundMessageDisplayed= listNotFoundMessage.isDisplayed();
	return isResultNotFoundMessageDisplayed;
}
}

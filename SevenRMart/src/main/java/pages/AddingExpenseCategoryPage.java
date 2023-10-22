package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AddingExpenseCategoryPage {
	public WebDriver driver;
	public WaitUtility waitutility;
	public FileUploadUtility fileuploadutility;
	public PageUtility pageutility;
	
	public AddingExpenseCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath=("//i[contains(@class,'fa-money-bill-alt')]//following-sibling::p"))private WebElement manageExpenseCategory;
@FindBy(xpath=("//ul[@role='menu']//following::p[text()='Expense Category']"))private WebElement expenseCategory;
@FindBy(xpath=("//a[@onclick='click_button(1)']"))private WebElement addButton;
@FindBy(xpath=("//input[@id='name']"))private WebElement titleField;
@FindBy(xpath=("//button[@name='Create']"))private WebElement saveButton;
@FindAll({@FindBy(xpath="//table[contains(@class,'table-bordered')]//following::tbody")})private List<WebElement>expenseCategoryList;
 
public AddingExpenseCategoryPage clickOnManageExpenseCategory()
{
	manageExpenseCategory.click();
	return this;
}
public AddingExpenseCategoryPage clickOnExpenseCategory()
{
	expenseCategory.click();
	return this;
}
public AddingExpenseCategoryPage clickOnAddButton()
{
	addButton.click();
	return this;

}
public AddingExpenseCategoryPage enterTheCategoryTitle(String categoryTitle)
{
	titleField.sendKeys(categoryTitle);
	return this;

}
public AddingExpenseCategoryPage clickOnSaveButton()
{
	saveButton.click();
	return this;

}
public boolean verifyNewCategoryIsAdded(String categoryTitle)
{
	boolean flag=false;
	for(WebElement expenseCategory:expenseCategoryList)
	{
		String getExpenseCategory=expenseCategory.getText();
		if(getExpenseCategory.contains(categoryTitle))
		{
			flag=true;
			break;
		}
	}
	return flag;
}

}

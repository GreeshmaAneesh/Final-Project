package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddingExpenseCategoryPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class AddingExpenseCategoryTest extends Base {
	public LoginPage loginpage;
	public AddingExpenseCategoryPage addingexpensecategorypage;
	@Test(retryAnalyzer = Retry.class,description="verify that the user can add and delete an expense category")
public void verifyUserCanAddExpenseCategoryAndCanDeleteThatCategory()
{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String categoryTitle=ExcelUtility.getString(1, 0, "AddingExpenseCategoryPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		addingexpensecategorypage=new AddingExpenseCategoryPage(driver);
		addingexpensecategorypage.clickOnManageExpenseCategory().clickOnExpenseCategory().clickOnAddButton().enterTheCategoryTitle(categoryTitle).clickOnSaveButton();
		boolean isaddedCategoryPresent=addingexpensecategorypage.verifyNewCategoryIsAdded(categoryTitle);
		assertTrue(isaddedCategoryPresent,"The added expense category is not present in the list");

}
}

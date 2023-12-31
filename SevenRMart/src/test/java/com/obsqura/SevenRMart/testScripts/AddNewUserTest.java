package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class AddNewUserTest extends Base
{
	public LoginPage loginpage;
	public AddNewUserPage addnewuserpage;
@Test(retryAnalyzer = Retry.class, description="Verify the user can add a new user on admin users")
public void verifyUserCanAddNewUserOnAdminUsers()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String usernameOfAdmin=ExcelUtility.getString(1, 0, "AddNewUser");
		String passwordOfAdmin=ExcelUtility.getString(1, 1, "AddNewUser");
		String userTypeOfAdmin=ExcelUtility.getString(1, 2, "AddNewUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		addnewuserpage=new AddNewUserPage(driver);
		addnewuserpage.clickOnAdminUser().clickOnNewButton().enterUsernameField(usernameOfAdmin).enterpasswordField(passwordOfAdmin).enterUserType(userTypeOfAdmin).clickOnSaveButton();
		boolean isAlertMessageDisplayed=addnewuserpage.alertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed,"Not able to add new admin user");
	}
}

package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	public LoginPage loginpage;
	public LogOutPage logoutpage;
@Test
public void verifyUserCanAddNewUserOnAdminUsers()
{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	String expectedResult=loginpage.getHomeText();
	logoutpage=new LogOutPage(driver);
	logoutpage.clickOnAdminButton().SelectLogoutButtonFromDropDown().isSignInPageDisplayed();
	boolean isSignInPageDisplayed=logoutpage.isSignInPageDisplayed();
	assertTrue(isSignInPageDisplayed,"User is unable to logout");
}

}

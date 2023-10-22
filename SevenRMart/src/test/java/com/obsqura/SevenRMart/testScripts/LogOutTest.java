package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LogOutPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	public LoginPage loginpage;
	public LogOutPage logoutpage;
@Test(retryAnalyzer = Retry.class, description="verify that user can add logout by clicking the logout button",groups= {"smoke"})
public void verifyUserCanLogout()
{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	logoutpage=new LogOutPage(driver);
	logoutpage.clickOnAdminButton().SelectLogoutButtonFromDropDown().isSignInPageDisplayed();
	boolean isSignInPageDisplayed=logoutpage.isSignInPageDisplayed();
	assertTrue(isSignInPageDisplayed,"User is unable to logout");
}

}

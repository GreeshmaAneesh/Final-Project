package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	public LoginPage loginpage;
@Test(retryAnalyzer = Retry.class, description="Verify that user can login with correct username and password")
public void verifyuserCanLoginWithCorrectUserNameAndPassword()
{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	String expectedResult=loginpage.getHomeText();
	Assert.assertEquals(actualResult, expectedResult, "User is unable to login with correct username and password");
}
@Test(retryAnalyzer = Retry.class, description="Verify user is unable to login with incorrect username and password")
public void verifyUserIsUnableToLoginWithIncorrectUserNameAndPassword()
{
	String username=ExcelUtility.getString(1, 2, "LoginPage");
	String password=ExcelUtility.getString(1, 3, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	boolean isinvalidMessageDisplayed=loginpage.alertMessage();
	assertTrue(isinvalidMessageDisplayed, "User is able to login with incorrect username and correct password");
}
@Test(retryAnalyzer = Retry.class, description="Verify user is unable to login with correct username and incorrect password")
public void verifyUserIsUnableToLoginUsingCorrectUserNameAndIncorrectPassword()
{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 3, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	boolean isinvalidMessageDisplayed=loginpage.alertMessage();
	assertTrue(isinvalidMessageDisplayed, "User is able to login with incorrect username and correct password");
}
@Test(retryAnalyzer = Retry.class, description="verify user is unable to login with incorrect username and correct password")
public void verifyUserIsUnableToLoginUsingIncorrectUserNameAndCorrectPassword()
{
	String username=ExcelUtility.getString(1, 2, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	boolean isinvalidMessageDisplayed=loginpage.alertMessage();
	assertTrue(isinvalidMessageDisplayed, "User is able to login with incorrect username and correct password");
}
}

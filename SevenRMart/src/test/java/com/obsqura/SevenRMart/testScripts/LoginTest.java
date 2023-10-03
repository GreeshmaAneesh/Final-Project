package com.obsqura.SevenRMart.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	public LoginPage loginpage;
@Test
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
public void verifyUserIsUnableToLoginWithIncorrectUserNameAndPassword()
{
	String username=ExcelUtility.getString(1, 2, "LoginPage");
	String password=ExcelUtility.getString(1, 3, "LoginPage");
	String actualMessage=ExcelUtility.getString(1, 5, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	String expectedMessage=loginpage.getHomeText();
	Assert.assertEquals(actualMessage, expectedMessage, "User is able to login with incorrect username and password");
}
public void verifyUserIsUnableToLoginUsingCorrectUserNameAndIncorrectPassword()
{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 3, "LoginPage");
	String actualMessage=ExcelUtility.getString(1, 5, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	String expectedMessage=loginpage.getHomeText();
	Assert.assertEquals(actualMessage, expectedMessage, "User is able to login with correct username and incorrect password");
}
@Test
public void verifyUserIsUnableToLoginUsingIncorrectUserNameAndCorrectPassword()
{
	String username=ExcelUtility.getString(1, 2, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	String actualMessage=ExcelUtility.getString(1, 5, "LoginPage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	String expectedMessage=loginpage.getHomeText();
	Assert.assertEquals(actualMessage, expectedMessage, "User is able to login with incorrect username and correct password");
}
}

package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.CreateNewsPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CreateNewsTest extends Base{
	public LoginPage loginpage;
	public CreateNewsPage createnewspage;
	@Test
	public void verifyUserCanCreateNewsText()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
		String newsText=ExcelUtility.getString(1, 0, "CreateNewsPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String expectedResult=loginpage.getHomeText();
		createnewspage=new CreateNewsPage(driver);
		createnewspage.clickOnManageNews().clickOnNewButton().enterTheTextInNewsField(newsText).clickOnSaveButton();
		createnewspage.isAlertMessageDisplayed();
		boolean isNewsCreatedAdded=createnewspage.isAlertMessageDisplayed();
		assertTrue(isNewsCreatedAdded,"Not able to add new news text");
	}

}

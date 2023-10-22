package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.CreateNewsPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class CreateNewsTest extends Base{
	public LoginPage loginpage;
	public CreateNewsPage createnewspage;
	@Test(retryAnalyzer = Retry.class, description="Verify that user can create a news",groups= {"regression"})
	public void verifyUserCanCreateNewsText()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String newsText=ExcelUtility.getString(1, 0, "CreateNewsPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		createnewspage=new CreateNewsPage(driver);
		createnewspage.clickOnManageNews().clickOnNewButton().enterTheTextInNewsField(newsText).clickOnSaveButton();
		createnewspage.isAlertMessageDisplayed();
		boolean isNewsCreatedAdded=createnewspage.isAlertMessageDisplayed();
		assertTrue(isNewsCreatedAdded,"Not able to add new news text");
	}

}

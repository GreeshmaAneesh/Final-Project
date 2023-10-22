package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.StatusChangeOfLocationPage;
import retry.Retry;
import utilities.ExcelUtility;

public class StatusChangeOfLocationTest extends Base{
	public LoginPage loginpage;
	public StatusChangeOfLocationPage Statuschangeoflocationpage;
	
	@Test(retryAnalyzer = Retry.class, description="verify that a user can change the status of the location")
	public void verifyTheUserCanChangeTheStatusOfLocation()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		Statuschangeoflocationpage=new StatusChangeOfLocationPage(driver);
		Statuschangeoflocationpage.clickOnManageLocations().clickOnActiveStatusButton();
		Statuschangeoflocationpage.alertMessageIsDisplayed();
		boolean isStatusOfLocationChanged=Statuschangeoflocationpage.alertMessageIsDisplayed();
		assertTrue(isStatusOfLocationChanged,"Not able to change the location status");
	}

}
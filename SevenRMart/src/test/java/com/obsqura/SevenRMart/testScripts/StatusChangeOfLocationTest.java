package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.LoginPage;
import pages.StatusChangeOfLocationPage;
import utilities.ExcelUtility;

public class StatusChangeOfLocationTest extends Base{
	public LoginPage loginpage;
	public StatusChangeOfLocationPage Statuschangeoflocationpage;
	
	@Test
	public void verifyTheUserCanChangeTheStatusOfLocation()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
		String expectedLocation=ExcelUtility.getString(1, 0, "StatusChangeOfLocationPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String expectedResult=loginpage.getHomeText();
		Statuschangeoflocationpage=new StatusChangeOfLocationPage(driver);
		Statuschangeoflocationpage.clickOnManageLocations().clickOnActiveStatusButton();
		Statuschangeoflocationpage.alertMessageIsDisplayed();
		boolean isStatusOfLocationChanged=Statuschangeoflocationpage.alertMessageIsDisplayed();
		assertTrue(isStatusOfLocationChanged,"Not able to change the location status");
	}

}

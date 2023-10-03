package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.AddNewMobileSliderPage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class AddNewMobileSliderTest extends Base{
	public LoginPage loginpage;
	public AddNewMobileSliderPage addnewmobilesliderpage;
	@Test
	public void verifyUserCanAddNewMobileSlider() throws AWTException
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
		String categoryName=ExcelUtility.getString(1, 0, "AddNewMobileSliderPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String expectedResult=loginpage.getHomeText();
		addnewmobilesliderpage=new AddNewMobileSliderPage(driver);
		addnewmobilesliderpage.clickOnMobileSlidebarmenu().clickOnAddButton().selectCategory(categoryName).uploadImage().clickOnSaveButton();
		boolean isAlertMessageDisplayed=addnewmobilesliderpage.IsAlertMessageDisplayed();
		assertTrue(isAlertMessageDisplayed,"Not able to add new mobile slider ");


	}

}

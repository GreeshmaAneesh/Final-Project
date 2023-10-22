package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AddNewMobileSliderPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import retry.Retry;


public class AddNewMobileSliderTest extends Base
{
	public LoginPage loginpage;
	public AddNewMobileSliderPage addnewmobilesliderpage;
	@Test(retryAnalyzer = Retry.class,dataProvider="LoginProvider", description="verify that the user can add a new ,mobileSlider")
	public void verifyUserCanAddNewMobileSlider(String username,String password) throws AWTException
	{
		String categoryName=ExcelUtility.getString(1, 0, "AddNewMobileSliderPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		addnewmobilesliderpage=new AddNewMobileSliderPage(driver);
		addnewmobilesliderpage.clickOnMobileSlidebarmenu().clickOnAddButton().selectCategory(categoryName).uploadImage().clickOnSaveButton();
		boolean isAlertMessageDisplayed=addnewmobilesliderpage.IsAlertMessageDisplayed();
		assertTrue(isAlertMessageDisplayed,"Not able to add new mobile slider ");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(1, 0, "LoginPage"), ExcelUtility.getString(1, 1, "LoginPage") },

		};
	}
}

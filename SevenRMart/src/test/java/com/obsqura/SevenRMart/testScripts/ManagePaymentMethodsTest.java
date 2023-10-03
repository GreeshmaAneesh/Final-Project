package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePaymentMethodsPage;

import utilities.ExcelUtility;

public class ManagePaymentMethodsTest extends Base {
	public LoginPage loginpage;
	public ManagePaymentMethodsPage managepaymentmethodspage;
@Test
	public void verifyUserCanUpdateThePaymentMethod() 
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
		String updatedTitle=ExcelUtility.getString(1, 0, "ManagePaymentMethodsPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String expectedResult=loginpage.getHomeText();
		managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickOnManagePaymentMethods().clickOnEditButton().enterTheUpdatedTitle(updatedTitle).clickOnUpdateButton();
		boolean isAlertMessageDisplayed=managepaymentmethodspage.isAlertMessageDisplayed();
		assertTrue(isAlertMessageDisplayed,"Not able to update title of payment method ");

		
		
		
	}
}

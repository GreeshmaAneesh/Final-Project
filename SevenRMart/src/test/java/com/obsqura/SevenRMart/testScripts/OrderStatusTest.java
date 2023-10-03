package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.LoginPage;
import pages.OrderStatusPage;
import utilities.ExcelUtility;

public class OrderStatusTest extends Base {
	public LoginPage loginpage;
	public OrderStatusPage OrderStatuspage;
	@Test
	public void verifyEnteringWrongOrderIdWillDisplayResultNotFoundMessage()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
		String orderId=ExcelUtility.getString(1, 0, "OrderStatusPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String expectedResult=loginpage.getHomeText();
		OrderStatuspage=new OrderStatusPage(driver);
		OrderStatuspage.clickOnManageOrders().clickOnSearchButton().enterTheWrongOrderId(orderId).clickOnSearchOrderButton().isResultNotFoundMessageDisplayed();
		boolean isMessageDisplayed=OrderStatuspage.isResultNotFoundMessageDisplayed();
		assertTrue(isMessageDisplayed,"Result not found message was not displayed");
		
	
	}

}

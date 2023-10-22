package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrderStatusPage;
import retry.Retry;
import utilities.ExcelUtility;

public class OrderStatusTest extends Base {
	public LoginPage loginpage;
	public OrderStatusPage OrderStatuspage;
	@Test(retryAnalyzer = Retry.class, description="Verify the user will get result not found message on entering wrong orderId")
	public void verifyEnteringWrongOrderIdWillDisplayResultNotFoundMessage()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String orderId=ExcelUtility.getString(1, 0, "OrderStatusPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		OrderStatuspage=new OrderStatusPage(driver);
		OrderStatuspage.clickOnManageOrders().clickOnSearchButton().enterTheWrongOrderId(orderId).clickOnSearchOrderButton().isResultNotFoundMessageDisplayed();
		boolean isMessageDisplayed=OrderStatuspage.isResultNotFoundMessageDisplayed();
		assertTrue(isMessageDisplayed,"Result not found message was not displayed");	
	}

}

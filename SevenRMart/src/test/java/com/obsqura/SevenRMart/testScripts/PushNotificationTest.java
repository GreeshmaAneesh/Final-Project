package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PushNotificationPage;
import retry.Retry;
import utilities.ExcelUtility;

public class PushNotificationTest extends Base{
	public LoginPage loginpage;
	public PushNotificationPage pushnotificationpage;
	@Test(retryAnalyzer = Retry.class, description="verify thath the user can push notifications")
	public void verifyUserCanPushNotifications()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String title=ExcelUtility.getString(1, 0, "PushNotificationPage");
		String description=ExcelUtility.getString(1, 1, "PushNotificationPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.clickOnPushNotificationsButton().enterTitleOnTitleField(title).enterDescriptionOnDescriptionField(description).clickOnSendButton();
		boolean isAlertMessageDisplayed=pushnotificationpage.IsAlertMessageDisplayed();
		assertTrue(isAlertMessageDisplayed,"Not able to push notifications");
	}
}

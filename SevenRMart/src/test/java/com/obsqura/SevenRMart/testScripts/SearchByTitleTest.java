package com.obsqura.SevenRMart.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchByTitlePage;
import utilities.ExcelUtility;

public class SearchByTitleTest extends Base{
	public LoginPage loginpage;
	public SearchByTitlePage searchbytitlepage;
@Test
public void verifyUserCanSearchAProductByTitleONManagePages()
{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	String actualResult=ExcelUtility.getString(1, 4, "LoginPage");
	String Title=ExcelUtility.getString(1, 0, "SearchByTitlePage");
	loginpage=new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	String expectedResult=loginpage.getHomeText();
	searchbytitlepage=new SearchByTitlePage(driver);
	searchbytitlepage.clickOnManagePages().clickOnSearchButton().enterTitleOnTitleField(Title).ClickOnSearchByTitleButton().listPagesWithTheTitleSearchedIsDisplayed();
	boolean istitledisplayed=searchbytitlepage.listPagesWithTheTitleSearchedIsDisplayed();
	assertTrue(istitledisplayed,"Not able to search by title");

}
}

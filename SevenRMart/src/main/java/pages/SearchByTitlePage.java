package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchByTitlePage {
public WebDriver driver;
	public SearchByTitlePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//div[@class='icon']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")private WebElement managePages;
@FindBy(xpath="//div[@align='right']//following::a[@onclick='click_button(2)']")private WebElement searchButton;
@FindBy(xpath = "//input[@placeholder='Title']")private WebElement TitleField;
@FindBy(xpath="//button[@name='Search']")private WebElement SearchByTitleButton;
@FindBy(xpath="//div[@class='card ']//following::td[text()='fruits']")private WebElement listPagesTable;
public SearchByTitlePage clickOnManagePages()
{
	managePages.click();
	return this;
}
public SearchByTitlePage clickOnSearchButton()
{
	searchButton.click();
	return this;

}
public SearchByTitlePage enterTitleOnTitleField(String Title)
{
	TitleField.sendKeys(Title);
	return this;

}
public SearchByTitlePage ClickOnSearchByTitleButton()
{
	SearchByTitleButton.click();
	return this;

}
public boolean listPagesWithTheTitleSearchedIsDisplayed()
{
	boolean listPagesWithTheTitleSearchedIsDisplayed=listPagesTable.isDisplayed();
	return listPagesWithTheTitleSearchedIsDisplayed;
}
}



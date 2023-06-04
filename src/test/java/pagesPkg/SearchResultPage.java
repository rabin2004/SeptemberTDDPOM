package pagesPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class SearchResultPage extends BaseClass{

	@FindBy(xpath="//span[contains(text(),'results for')]")
	WebElement searchResultHeader;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSearchResultHeader() {
		return searchResultHeader.isDisplayed();
	}
	
	public boolean validateSearchResultPageTitle(String product) {
		return driver.getTitle().contains(product);
	}
	
	public boolean validateSearchResultPageURL(String product) {
		return driver.getCurrentUrl().contains(product);
	}
}

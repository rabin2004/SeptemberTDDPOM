package pagesPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class HomePage extends BaseClass{
	
	// 1. Creating webElement -> @FindBy
	// 2. Create constructor to load webElement to the driver instance
	// 3. define method for action/s to be performed on webElement 
	
	@FindBy(id="twotabsearchtextbox") // driver.findElement(id="twotabsearchtextbox")
	WebElement searchTxtBox;
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductSearchTxtBox(String product) {
		searchTxtBox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}

}

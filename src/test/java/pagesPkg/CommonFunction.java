package pagesPkg;

import basePkg.BaseClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.*;

public class CommonFunction extends BaseClass{
	Actions action = new Actions(driver);
	
	public void hittingEnterKey() {
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public boolean menuLinkTargetPageTitleValidation(String menuLink) {
		return driver.getTitle().contains(menuLink);
	}

}

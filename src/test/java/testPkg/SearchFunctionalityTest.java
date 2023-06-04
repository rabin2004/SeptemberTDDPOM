package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pagesPkg.HomePage;
import pagesPkg.SearchResultPage;

public class SearchFunctionalityTest extends BaseClass{
	static HomePage hp;
	static SearchResultPage srp;
	
	@BeforeMethod(alwaysRun=true)
	public void load() {
		loadApp();
		hp = new HomePage();
		srp = new SearchResultPage();
	}
	
	@AfterMethod(alwaysRun=true)
	public void close() {
		tearDown();
	}
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="positiveSearchData")
	public void positiveSearchFunctionalityTestWithSearchBtn(String product) {
		hp.enterProductSearchTxtBox(product);
		hp.clickSearchBtn();
		
		if(srp.validateSearchResultHeader()) {
			Assert.assertTrue(srp.validateSearchResultPageTitle(product));
			Assert.assertTrue(srp.validateSearchResultPageURL(product));
		}else {
			Assert.assertTrue(false);
		}
	}

}

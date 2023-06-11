package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pagesPkg.CommonFunction;
import pagesPkg.HomePage;
import org.testng.annotations.Parameters;

public class HomePageMenuLinkFunctionalityTest extends BaseClass{
	
	static HomePage hp;
	static CommonFunction cf;
	
	@BeforeClass(alwaysRun=true)
	public void load() {
		loadApp();
		hp = new HomePage();
		cf = new CommonFunction();
	}
	
	@AfterMethod(alwaysRun=true)
	public void backToHomePage() {
		navigateBack();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApp() {
		tearDown();
	}
	
	@Test (dataProviderClass=dataPkg.MenuLinks.class, dataProvider="menu links", groups="Smoke")
	public void quickMenuLinkTest(String menuLink) {
		hp.headerMenuLinkClick(menuLink);
		Assert.assertTrue(cf.menuLinkTargetPageTitleValidation(menuLink));
	}
	
	@Parameters({"menuLink","check"})
	@Test (groups="Sanity")
	public void quickMenuLinkTestThroughParameterziedXML(String menuLink, String check) {
		hp.headerMenuLinkClick(menuLink);
		Assert.assertTrue(cf.menuLinkTargetPageTitleValidation(menuLink));
		System.out.println(check);
	}

}

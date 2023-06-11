package dataPkg;

import org.testng.annotations.DataProvider;

public class MenuLinks {
	
	@DataProvider (name="menu links")
	public String[] menuLinkData() {
		String[] data = {	"Clinic",
							"Best Sellers",
							"Amazon Basics"
		};
		
		return data;
	}

}

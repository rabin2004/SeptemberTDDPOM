package basePkg;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\eclipse-workspace\\"
					+ "SeptemberTDDPOM\\src\\main\\java\\configPkg\\config.properties"));
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadApp() {
		String browser = prop.getProperty("browserName").toLowerCase();

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			System.out.println("Testing in Chrome");
			break;

		case "firefox":
			driver = new FirefoxDriver();
			System.out.println("Testing in Firefox");
			break;

		case "edge":
			driver = new EdgeDriver();
			System.out.println("Testing in Edge");
			break;

		default:
			System.err.println("Broswer not supported!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(prop
				.getProperty("implicitWait"))));
		driver.get(prop.getProperty("testURL"));
	}
	
	public void tearDown() {
		driver.quit();
	}
}

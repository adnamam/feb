package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	
	private static WebDriver driver;
	
	
	public static WebDriver driver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}
	
//	public WebDriver createDriver() {
//		
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setPlatform(Platform.ANY);
//		capability.setJavascriptEnabled(true);
//		
//		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
//		capability = DesiredCapabilities.chrome();
//		
//		try {
//			driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capability);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		return driver;
//	}
	
	public static WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/Users/amarrione/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * Quits and removes the driver
	 */
	public static void quit() {
		if (driver == null) {
			return;
		}
		try {
			driver().quit();
			driver = null;
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
}
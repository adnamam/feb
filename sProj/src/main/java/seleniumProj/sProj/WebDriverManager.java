package seleniumProj.sProj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
	
	WebDriver driver;
	private static String driverPath = "C:\\";
	
	public WebDriver driver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}
	
	public WebDriver createDriver() {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.ANY);
		capability.setJavascriptEnabled(true);
		
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		capability = DesiredCapabilities.chrome();
		
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}

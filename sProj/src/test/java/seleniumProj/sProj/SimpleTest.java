package seleniumProj.sProj;

import org.junit.Test;
import org.openqa.selenium.By;

public class SimpleTest extends WebDriverManager {
	
	@Test
	public void simpleTest() {
		driver();
		driver().get("https://masttest.stsci.edu/portal/Mashup/Clients/Mast/Portal.html");
		driver().findElement(By.linkText("Random Search"));
		
		driver.quit();
	}

}

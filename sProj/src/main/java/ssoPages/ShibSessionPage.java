package ssoPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class ShibSessionPage extends BasePage{

	public ShibSessionPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * gets text on page for when there is no session
	 * @return
	 */
	public String noSessionText() {
		String text = null;
		
		try {
			text = driver.findElement(By.xpath("html/body/pre")).getText();
		} catch(NoSuchElementException e) {
			Assert.fail("A shib session was found when one was not expected");
		}
		return text;
	}
	
	/**
	 * gets text on page for when there is an active session
	 * @return
	 */
	public String sessionText() {
	String text = null;
		
		try {
			text = driver.findElement(By.xpath("html/body/pre/strong[1]")).getText();
		} catch(NoSuchElementException e) {
			Assert.fail("A shib session was not found when one was expected");
		}
		return text;
	}

}

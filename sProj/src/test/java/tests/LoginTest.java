package tests;

import org.junit.Test;

import pages.HeaderPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() {
		
//		HeaderPage hp = getHeaderPage();
		
		//need development flag to see advanced search
		driver().get("https://masttest.stsci.edu/portal/Mashup/Clients/Mast/Portal.html?development");
		HeaderPage hp = getPage(HeaderPage.class);
		hp.loginFromPortal();
		
	}

}

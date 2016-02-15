package ssoTests;

import org.junit.Assert;
import org.junit.Test;

import pages.SSOPage;
import ssoPages.ShibSessionPage;
import tests.BaseTest;

/**
 * Test for Shibboleth functionality
 * Layer 1 of SSO Test Plan
 * @author amarrione
 *
 */
public class ShibFunctionalityTest extends BaseTest{
	
	private final static String noSession = "A valid session was not found.";
	private final static String session = "Session Expiration (barring inactivity):";
	
	@Test
	public void shibFunctionalityTest() {
		//check session page
		driver().get("https://masttest.stsci.edu/Shibboleth.sso/Session");
		ShibSessionPage shib = getPage(ShibSessionPage.class);
		String st = shib.noSessionText();
		//verify no session exists
		Assert.assertTrue("A shib session was found when one was not expected", st.equals(noSession));	
		
		//login
		driver().get("https://masttest.stsci.edu/Shibboleth.sso/Login");
		SSOPage sso = getPage(SSOPage.class);
		sso.enterAndSubmitLoginInfo("masttestusertwo@gmail.com", "GilligansIsland1");
		
		//go back to session page
		driver().get("https://masttest.stsci.edu/Shibboleth.sso/Session");
		ShibSessionPage shib2 = getPage(ShibSessionPage.class);
		String st2 = shib2.sessionText();
		//verify session does exist now
		Assert.assertTrue("A shib session was not found when one was expected", st2.equals(session));
	}

}

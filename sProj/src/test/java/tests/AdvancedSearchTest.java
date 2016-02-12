package tests;

import org.junit.Test;

import pages.HeaderPage;
import popupPages.AdvancedSearchPage;

public class AdvancedSearchTest extends BaseTest{
	
	@Test
	public void advancedSearchTest() {
//		HeaderPage hp = getHeaderPage();
		
		//need development flag to see advanced search
		driver().get("https://masttest.stsci.edu/portal/Mashup/Clients/Mast/Portal.html?development");
		AdvancedSearchPage as = getPage(HeaderPage.class).clickAdvancedSearch();
		

		//filter HST mission and verify breadcrumb is displayed
		as.clickFilterCheckbox("HST");
		as.getBreadCrumb("Mission: HST");
		as.stuff("Enter text here");
		
		
	}

}
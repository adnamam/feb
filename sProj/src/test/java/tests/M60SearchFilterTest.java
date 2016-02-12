package tests;

import org.junit.Test;

import pages.FiltersPage;

public class M60SearchFilterTest extends BaseTest{
	
	@Test
	public void m60SearchFilterTest() throws Exception {
		//perform search
		getHeaderPage().searchForTarget("M60");
		
		FiltersPage filt = getPage(FiltersPage.class);
		
		//click image filter
		filt.filterImage();
		filt.checkFilterResult("243", "image");
		
		//clear filter
		filt.clearFilter();
		
		//click HST filter
		filt.filterHST();
		filt.checkFilterResult("290", "HST");
		
		//clear filter
		filt.clearFilter();
		
		//click HST+DADS filter
		filt.filterHST();
		filt.filterDADS();
		filt.checkFilterResult("188", "HST+DADS");
		
		//click HST+ACS/WFC+DADS filter
		filt.filterACS();
		filt.checkFilterResult("12", "HST+DADS+ACS/WFC");
		
		//clear filter
		filt.clearFilter();
		
		//click HST+HLA filter
		filt.filterHST();
		filt.filterHLA();
		filt.checkFilterResult("102", "HST+HLA");
	}
}
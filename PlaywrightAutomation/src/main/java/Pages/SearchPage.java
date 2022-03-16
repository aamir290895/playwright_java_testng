package Pages;

import com.microsoft.playwright.Page;

import Config.Setup;

public class SearchPage {

	private Page page;
	

	public SearchPage(Page page) {
		this.page = page;
	}
	
	public void search(String locator,String query) {
        page.fill(locator, query);
    }
}

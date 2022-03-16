package Tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import Config.Setup;
import Pages.SearchPage;

public class TestCases {
	
	
	
	@Test
	void searchTest() {
		Setup s = new Setup();
		s.setup("firefox", "https://www.flipkart.com");
		
//	    SearchPage searchPage = new SearchPage(page);
		
		
	}

}

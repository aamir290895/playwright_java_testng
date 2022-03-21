package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import Config.Setup;
import Pages.BasePage;

public class TestCases {
	
	BasePage basePage = null;
	
	@BeforeTest
	public BasePage beforeTest() {
		Setup s = new Setup();
		Page page = s.setup("chromium", "https://www.flipkart.com");
		basePage = new BasePage(page);
		
		return basePage;
	}
	
	@Test
	void preTest() throws InterruptedException {
		
		basePage.search("//input[@class='_3704LK']", "iphone13");
		basePage.mouseMove(58, 96);

	}

	@Test
	void searchTest() throws InterruptedException {
		

	}
}

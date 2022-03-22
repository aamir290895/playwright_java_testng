package Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import config.Setup;
import pages.LoginPage;
import reports.JSONReporter;
@Listeners({JSONReporter.class})
public class TestCases {
	
    private Page page;
	
	@BeforeTest
	public Page beforeTest() {
		Setup s = new Setup();
		page = s.setup("chromium", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		return page;
	}
	
	@Test
	void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(page);
		loginPage.login("Admin", "admin123");
        
	}

	@Test
	void searchTest() throws InterruptedException {
		

	}
	
}

package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class BasePage {

	private Page page;

	public BasePage(Page page) {
		this.page = page;
	}

	public void search(String locator, String query) {
		page.fill(locator, query);
	}

	public void handlePages(Browser browser) {

		browser.newContext().onPage(page -> {
			page.waitForLoadState();
			System.out.println(page.title());
		});

	}

	public void mouseMove(double x, double y) throws InterruptedException {

		page.mouse().move(x, y);

	}
	
	
	public void mouseUp() throws InterruptedException {

		page.mouse().up();

	}
	
	public void mouseDown() throws InterruptedException {

		page.mouse().down();

	}

}

package Pages;

import com.microsoft.playwright.Page;

public class Utilities extends BasePage {
	
	private Page page;

	public Utilities(Page page) {
		super(page);
		
	   this.page = page;
	}

	public void handleDialog(String locator) {

		page.onDialog(dialog -> dialog.accept());
		page.click(locator);
	}

}

package pages;

import com.microsoft.playwright.Page;

import locators.Locators;

public class LoginPage extends BasePage {
	
	private Locators locators;
	
	private Page page;

	public LoginPage(Page page) {
		super(page);
		this.page =page;
	}

	
	public void login(String username , String password) {
		page.fill(locators.loc_user_name,username);
		page.fill(locators.loc_password, password);
		page.click(locators.loc_loginbtn);
		
	}
}

package config;

import com.microsoft.playwright.Page;

public class Setup {
	
	public Page setup(String browserName , String url) {
				
        Page page = Browsers.selectBrowser(browserName).newPage();
        page.navigate(url);
		return page;
		
	}
 
	
}

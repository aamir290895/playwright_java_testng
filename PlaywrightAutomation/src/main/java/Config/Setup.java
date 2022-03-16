package Config;

import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Page;

public class Setup {
	
	@BeforeClass
	public Page setup(String browserName , String url) {
		Browsers browser = new Browsers();
				
        Page page = browser.selectBrowser(browserName).newPage();
        page.navigate(url);
		return page;
		
	}
 
}

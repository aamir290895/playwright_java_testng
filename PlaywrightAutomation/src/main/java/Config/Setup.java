package Config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

public class Setup {
	
	@BeforeClass
	public Page setup(String browserName , String url) {
				
        Page page = Browsers.selectBrowser(browserName).newPage();
        page.navigate(url);
		return page;
		
	}
 
	
}

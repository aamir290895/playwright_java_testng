package Config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class Browsers {
	
	
	public static Browser selectBrowser(String select) {
		Browser browser = null ;

		if(select == "chromium") {
			browser = Playwright
	                .create()
	                .chromium()
	                .launch(new BrowserType.LaunchOptions().setHeadless(false));
			
		}else if( select == "firefox") {
			browser = Playwright
	                .create()
	                .firefox()
	                .launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			
		}else if (select == "webkit") {
			browser = Playwright
	                .create()
	                .webkit()
	                .launch(new BrowserType.LaunchOptions().setHeadless(false));
			
		}
		return browser;
		
		
	}

}

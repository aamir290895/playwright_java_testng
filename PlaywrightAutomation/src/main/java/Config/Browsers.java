package Config;

import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public class Browsers {
	
	private Browser browser;
	private String chromium;
	private String firefox;
	private String webkit;
	
	
	public Browser selectBrowser(String select) {
		
		if(select == chromium) {
			browser = Playwright
	                .create()
	                .chromium()
	                .launch();
			
		}else if( select == firefox) {
			browser = Playwright
	                .create()
	                .firefox()
	                .launch();
			
			
		}else if (select == webkit) {
			browser = Playwright
	                .create()
	                .webkit()
	                .launch();
			
		}
		return browser;
		
		
	}

}

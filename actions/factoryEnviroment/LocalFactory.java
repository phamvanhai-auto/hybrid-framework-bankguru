package factoryEnviroment;

import org.openqa.selenium.WebDriver;

import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.Browsers;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.IEDriverManager;
import factoryBrowser.SafariDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		Browsers browser = Browsers.valueOf(browserName.toUpperCase());

		switch (browser) {
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
			
		case FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
			
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;
			
		case IE:
			driver = new IEDriverManager().getBrowserDriver();
			break;

		default:
			throw new BrowserNotSupportedException(browserName);
		}
		
		return driver;
	}
	
}

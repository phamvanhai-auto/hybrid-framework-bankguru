package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;

public class SafariDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		if(!IS_OS_MAC) {
			throw new BrowserNotSupportedException("IE not supported on " + System.getProperty("os.name"));
		}
		WebDriverManager.iedriver().architecture(Architecture.X32).setup();
		SafariOptions options = new SafariOptions();
		
		return new SafariDriver(options);
	}

}

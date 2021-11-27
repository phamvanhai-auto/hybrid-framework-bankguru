package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		
		//add extension
		FirefoxProfile profile = new FirefoxProfile();
		File file = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtension" + File.separator + "selectorshub-3.3.0-fx.xpi");
		profile.addExtension(file);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		
		//disable console log
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + File.separator + "browserLogs" + File.separator + "Firefox.log");
				
		return new FirefoxDriver(options);
	}

}

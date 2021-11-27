package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class SaucelabsFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	
	public SaucelabsFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", osName);
		caps.setCapability("browserName", browserName);
		caps.setCapability("browserVersion", "latest");
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_LABS_URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}

}

package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class BrowserstackFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String osVersion;
	
	public BrowserstackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", osName);
		caps.setCapability("os_version", osVersion);
		caps.setCapability("browser", browserName);
		caps.setCapability("browser_version", "latest");
		caps.setCapability("name", "Run on " + osName + " " + osVersion + " & " + browserName);
		caps.setCapability("resolution", "1920x1080");
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
}

package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class CrossbrowserFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	
	public CrossbrowserFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}
	
	public WebDriver createDriver() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browserName);
		caps.setCapability("platform", osName);
		
		caps.setCapability("screenResolution", "1920x1080");
		caps.setCapability("record_video", "true");
		caps.setCapability("name", "Run on " + osName + " & " + browserName);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.CROSS_LABS_URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
}

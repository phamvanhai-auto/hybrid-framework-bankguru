package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.BaseTest.BROWSER;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portName;
	
	public GridFactory(String browserName, String ipAddress, String portName) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portName = portName;
	}
	
	public WebDriver createDriver() {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
			//setBrowserDriverProperty();
			
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			
			FirefoxOptions fxOption = new FirefoxOptions();
			fxOption.merge(capability);
			
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", projectPath + ".\\browserDrivers\\chromedriver.exe");
			//setBrowserDriverProperty();
			//add extention
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			
			ChromeOptions chOption = new ChromeOptions();
			chOption.merge(capability);
			
		} 
		else {
			throw new RuntimeException("Please check browser again!");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portName)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
}

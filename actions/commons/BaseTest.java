package commons;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	public enum BROWSER {
		CHROME, FIREFOX, IE, EDGE, SAFARI, CHEADLESS, FHEADLESS
	}

	public WebDriver openMultipleBrowsers(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());

		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please check browser again!");
		}

		return driver;
	}

	public WebDriver openMultipleBrowsers(String browserName, String urlPage) {

		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());

		if (browser == BROWSER.FIREFOX) {
			//WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
			setBrowserDriverProperty();
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			//WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", projectPath + ".\\browserDrivers\\chromedriver.exe");
			setBrowserDriverProperty();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE) {
			//WebDriverManager.edgedriver().setup();
			// System.setProperty("webdriver.edge.driver", projectPath + ".\\browserDrivers\\msedgedriver.exe");
			setBrowserDriverProperty();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please check browser again!");
		}

		driver.get(urlPage);
		return driver;
	}

	//Cách 1: tự viết hàm
	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}
	
	//xử lý phần đuôi của driver (.exe or not)
	protected void setBrowserDriverProperty() {
		String browserFolderPath = projectPath + getDirectorySlash("browserDrivers");
		//String browserFolderPath = projectPath + getDirectorySlashByFileSeparator("browserDrivers");
		
		if (isWindows()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver.exe");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver_mac");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_mac");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver_mac");
		} else {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver_linux");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_linux");
		}
	}
	
	//Cách 2: Sử dụng thư viện Java (file.separator)
	private String getDirectorySlashByFileSeparator(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;

	}
	
	//Cách 3: sử dụng thư viện ngoài WebDriver Manager (open source) để tự check & download driver/browser version về & run
	
	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	public String genEmail() {
		Random rand = new Random();
		return "autofc" + rand.nextInt(9999) + "@mail.com";
		
	}
}

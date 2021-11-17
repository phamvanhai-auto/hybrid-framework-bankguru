package commons;

import java.io.File;

public class GlobalConstants {
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	
	public static final String DEV_APP_URL = "https://demo.nopcommerce.com";
	public static final String STAGING_APP_URL = "https://staging.nopcommerce.com";
	public static final String TESTING_APP_URL = "https://test.nopcommerce.com";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";

	public static final String BROWSER_USERNAME = "rfteam_l09gCs";
	public static final String BROWSER_AUTOMATE_KEY = "1CyxMBhNsSDzohzqLMsk";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCE_USERNAME = "oauth-vsm.hai.test-eac99";
	public static final String SAUCE_AUTOMATE_KEY = "b24287b0-036b-4815-ad4c-ee0e02c645e5";
	public static final String SAUCE_LABS_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	public static final String CROSS_USERNAME = "hai.pv@sharitekvn.com".replaceAll("@", "%40");
	public static final String CROSS_AUTOMATE_KEY = "u4bcff0d8b518fa3";
	public static final String CROSS_LABS_URL = "http://" + CROSS_USERNAME + ":" + CROSS_AUTOMATE_KEY + "@hub.crossbrowsertesting.com:80/wd/hub";
	
}

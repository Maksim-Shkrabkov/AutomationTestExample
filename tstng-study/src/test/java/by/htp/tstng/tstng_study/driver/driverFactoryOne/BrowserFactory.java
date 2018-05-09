package by.htp.tstng.tstng_study.driver.driverFactoryOne;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
	
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	
	private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	private static final String GECKODRIVER_GECKODRIVER_EXE_PATH = "C:\\driver\\geckodriver.exe";
	
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String CHROMEDRIVER_CHROMEDRIVER_EXE_PATH = "C:\\driver\\chromedriver.exe";
	
	private static final String WEBDRIVER_EDGE_DRIVER = "webdriver.edge.driver";
	private static final String MICROSOFTWEBDRIVER_MICROSOFTWEBDRIVER_EXE_PATH = "C:\\driver\\MicrosoftWebDriver.exe";
	
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		
		switch(browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_GECKODRIVER_EXE_PATH);
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		case "Edge":
			driver = drivers.get("Edge");
			if (driver == null) {
				System.setProperty(WEBDRIVER_EDGE_DRIVER, MICROSOFTWEBDRIVER_MICROSOFTWEBDRIVER_EXE_PATH);
				driver = new EdgeDriver();
				drivers.put("Edge", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_CHROMEDRIVER_EXE_PATH);
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		}
		
		return driver;
	}
	
	public static void closeAllDrivers() {
		for (String key: drivers.keySet()) {
			drivers.get(key).quit();
		}
	}

}

package by.htp.tstng.tstng_study.driver.driverFactoryThree;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class EdgeDriverCreator extends WebDriverCreator {

	public static final String PATH_TO_EDGEDRIVER = "C:\\driver\\MicrosoftWebDriver.exe";
	
	@Override
	public WebDriver factoryMethod() {
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_EDGEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        driver = new ChromeDriver(service);
        
        return driver;
	}

}

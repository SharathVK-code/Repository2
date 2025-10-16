package Automation.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver driver;

	public void initializeBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ambat\\git\\repository2\\Selenium\\src\\main\\resources\\GlobalData.Properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			// Invoking FireFox browser code

		} else if (browserName.equalsIgnoreCase("Edge")) {
			// Invoking Edge browser code

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}

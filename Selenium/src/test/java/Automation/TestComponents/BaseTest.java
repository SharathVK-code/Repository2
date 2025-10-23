package Automation.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.PageObjects.ZaraCoat3_LandingPage;

public class BaseTest {
	WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.Properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			// Invoking FireFox browser code

		} else if (browserName.equalsIgnoreCase("Edge")) {
			// Invoking Edge browser code

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	public ZaraCoat3_LandingPage launchApplication() throws IOException {
		driver = initializeBrowser();
		ZaraCoat3_LandingPage landingPage = new ZaraCoat3_LandingPage(driver);
		landingPage.goTo();
		return landingPage;

	}

}

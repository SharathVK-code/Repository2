package Automation.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSparkReporter
		
		
	}
	
	
	@Test
	public void initialDemo() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		System.out.println(driver.getTitle());

	}

}

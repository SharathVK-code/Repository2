package Automation.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.PageObjects.LandingPage;

public class e2e {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String desiredProduct = "ZARA COAT 3";

		// Landing page
		LandingPage lp = new LandingPage(driver);
		// Login Page
		lp.goTo();
		lp.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");

		driver.close();

	}

}
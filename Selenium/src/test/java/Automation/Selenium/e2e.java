package Automation.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.PageObjects.LandingPage;
import Automation.PageObjects.ProductCatalog;

public class e2e {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String desiredProduct = "ZARA COAT 3";

		// Landing page
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");

		// Product catalog
		ProductCatalog pc = new ProductCatalog(driver);
		pc.GetProductsList();
		System.out.println(pc.GetProductsList().get(1).getText());

//		driver.close();

	}

}
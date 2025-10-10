package Automation.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		List<WebElement> prod = pc.GetProductsList();
//		System.out.println(prod.get(0).getText());
		pc.addProductToCart(desiredProduct);

		driver.close();

	}

}
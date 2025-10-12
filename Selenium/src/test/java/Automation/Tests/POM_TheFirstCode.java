package Automation.Tests;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.PageObjects.CheckOutPage;
import Automation.PageObjects.LandingPage;
import Automation.PageObjects.PaymentPage;
import Automation.PageObjects.ProductCatalog;
import Automation.PageObjects.SuccessPage;

public class POM_TheFirstCode {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String desiredProduct = "ZARA COAT 3";

		// Landing page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");

		// Product catalog
		ProductCatalog productCatalog = new ProductCatalog(driver);
		List<WebElement> prod = productCatalog.GetProductsList();
		productCatalog.addProductToCart(desiredProduct);

		// CheckOut page
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		boolean flag = checkOutPage.VerifyProducrtDisplay(desiredProduct);
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		checkOutPage.ClickOnCheckOut();

		// payment page
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.EnterDetails(567, "Sharath", "India");

		// success page
		SuccessPage successPage = new SuccessPage(driver);
		String cnfrmMessage = successPage.validateConfirmMessage();
		Assert.assertEquals(cnfrmMessage, "THANKYOU FOR THE ORDER.");
		successPage.printOrderID();

		driver.close();

	}

}
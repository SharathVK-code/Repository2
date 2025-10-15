package Automation.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.PageObjects.CheckOutPage;
import Automation.PageObjects.LandingPage;
import Automation.PageObjects.PaymentPage;
import Automation.PageObjects.ProductCatalog;
import Automation.PageObjects.SuccessPage;

public class ZaraCoat3_POM_Standard_e2e {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String desiredProduct = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
		boolean flag = checkOutPage.VerifyProductDisplay(desiredProduct);
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
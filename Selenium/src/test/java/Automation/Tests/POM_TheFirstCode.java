package Automation.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.PageObjects.CheckOutPage;
import Automation.PageObjects.LandingPage;
import Automation.PageObjects.PaymentPage;
import Automation.PageObjects.ProductCatalog;
import Automation.PageObjects.SuccessPage;
import Automation.TestComponents.BaseTest;

public class POM_TheFirstCode extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String desiredProduct = "ZARA COAT 3";
		LandingPage landingpage = launchApplication();
		// Landing page
		landingpage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");

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
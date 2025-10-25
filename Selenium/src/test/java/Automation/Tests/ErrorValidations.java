package Automation.Tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import Automation.PageObjects.ZaraCoat3_CheckOutPage;
import Automation.PageObjects.ZaraCoat3_ProductCatalog;
import Automation.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups = "{errorHandling}")
	public void submitOrder() throws IOException, InterruptedException {

		landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18@18");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void SubmitOrderErrorValidation() throws IOException, InterruptedException {

		String desiredProduct = "ZARA COAT 3";
		// Product catalog
		ZaraCoat3_ProductCatalog productCatalog = landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");
		productCatalog.GetProductsList();
		// CheckOut page
		ZaraCoat3_CheckOutPage checkOutPage = productCatalog.addProductToCart(desiredProduct);
		boolean flag = checkOutPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(flag);

	}

}
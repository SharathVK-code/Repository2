package Automation.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.PageObjects.OrdersPage;
import Automation.PageObjects.ZaraCoat3_CheckOutPage;
import Automation.PageObjects.ZaraCoat3_PaymentPage;
import Automation.PageObjects.ZaraCoat3_ProductCatalog;
import Automation.PageObjects.ZaraCoat3_SuccessPage;
import Automation.TestComponents.BaseTest;

public class ZaraCoat3_POM_Standard_e2e_morph extends BaseTest {
	String desiredProduct = "ADIDAS ORIGINAL";

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		// Product catalog
		ZaraCoat3_ProductCatalog productCatalog = landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");
		List<WebElement> prod = productCatalog.GetProductsList();
		// CheckOut page
		ZaraCoat3_CheckOutPage checkOutPage = productCatalog.addProductToCart(desiredProduct);
		boolean flag = checkOutPage.VerifyProductDisplay(desiredProduct);
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		// payment page
		ZaraCoat3_PaymentPage paymentPage = checkOutPage.ClickOnCheckOut();
		// success page
		ZaraCoat3_SuccessPage successPage = paymentPage.EnterDetails(567, "Sharath", "India");
		String cnfrmMessage = successPage.validateConfirmMessage();
		Assert.assertEquals(cnfrmMessage, "THANKYOU FOR THE ORDER.");
		successPage.printOrderID();

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ZaraCoat3_ProductCatalog productCatalog = landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");
		OrdersPage ordersPage = productCatalog.ClickOnOrdersButton();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(desiredProduct));

	}

}
package Automation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.PageObjects.OrdersPage;
import Automation.PageObjects.ZaraCoat3_CheckOutPage;
import Automation.PageObjects.ZaraCoat3_PaymentPage;
import Automation.PageObjects.ZaraCoat3_ProductCatalog;
import Automation.PageObjects.ZaraCoat3_SuccessPage;
import Automation.TestComponents.BaseTest;

public class ZaraCoat3_POM_Standard_e2e_morph extends BaseTest {
//	String desiredProduct = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// Product catalog
		ZaraCoat3_ProductCatalog productCatalog = landingPage.loginUser(input.get("email"), input.get("password"));
		List<WebElement> prod = productCatalog.GetProductsList();
		// CheckOut page
		ZaraCoat3_CheckOutPage checkOutPage = productCatalog.addProductToCart(input.get("product"));
		boolean flag = checkOutPage.VerifyProductDisplay(input.get("product"));
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
		String desiredProduct = "ADIDAS ORIGINAL";
		ZaraCoat3_ProductCatalog productCatalog = landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");
		OrdersPage ordersPage = productCatalog.ClickOnOrdersButton();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(desiredProduct));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\Automation\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

//	@DataProvider
//	public Object[][] getData() {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "ambati.sharath500@gmail.com");
//		map.put("password", "SharathVK@18");
//		map.put("product", "ADIDAS ORIGINAL");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "ambatisarachandra@gmail.com");
//		map1.put("password", "SharathVK@18");
//		map1.put("product", "ZARA COAT 3");
//
//		return new Object[][] { { map }, { map1 } };
//
//	}
//
//	@DataProvider
//	public Object[][] getData() {
//
//		return new Object[][] { { "ambati.sharath500@gmail.com", "SharathVK@18", "ADIDAS ORIGINAL" },
//				{ "ambatisarachandra@gmail.com", "SharathVK@18", "ZARA COAT 3" } };
//
//	}

}
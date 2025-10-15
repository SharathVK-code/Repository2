package Automation.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.PageObjects.ZaraCoat3_CheckOutPage;
import Automation.PageObjects.ZaraCoat3_LandingPage;
import Automation.PageObjects.ZaraCoat3_PaymentPage;
import Automation.PageObjects.ZaraCoat3_ProductCatalog;
import Automation.PageObjects.ZaraCoat3_SuccessPage;

public class ZaraCoat3_POM_Standard_e2e {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String desiredProduct = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Landing page
		ZaraCoat3_LandingPage landingPage = new ZaraCoat3_LandingPage(driver);
		landingPage.goTo();
		landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");

		// Product catalog
		ZaraCoat3_ProductCatalog productCatalog = new ZaraCoat3_ProductCatalog(driver);
		List<WebElement> prod = productCatalog.GetProductsList();
		productCatalog.addProductToCart(desiredProduct);

		// CheckOut page
		ZaraCoat3_CheckOutPage checkOutPage = new ZaraCoat3_CheckOutPage(driver);
		boolean flag = checkOutPage.VerifyProductDisplay(desiredProduct);
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		checkOutPage.ClickOnCheckOut();

		// payment page
		ZaraCoat3_PaymentPage paymentPage = new ZaraCoat3_PaymentPage(driver);
		paymentPage.EnterDetails(567, "Sharath", "India");

		// success page
		ZaraCoat3_SuccessPage successPage = new ZaraCoat3_SuccessPage(driver);
		String cnfrmMessage = successPage.validateConfirmMessage();
		Assert.assertEquals(cnfrmMessage, "THANKYOU FOR THE ORDER.");
		successPage.printOrderID();

		driver.close();

	}

}
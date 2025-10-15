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

public class POM_Standard_e2e_Copy {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String desiredProduct = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Landing page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		// Product catalog
		ProductCatalog productCatalog = landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18");
		List<WebElement> prod = productCatalog.GetProductsList();
		// CheckOut page
		CheckOutPage checkOutPage = productCatalog.addProductToCart(desiredProduct);
		boolean flag = checkOutPage.VerifyProducrtDisplay(desiredProduct);
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		// payment page
		PaymentPage paymentPage = checkOutPage.ClickOnCheckOut();
		// success page
		SuccessPage successPage = paymentPage.EnterDetails(567, "Sharath", "India");
		String cnfrmMessage = successPage.validateConfirmMessage();
		Assert.assertEquals(cnfrmMessage, "THANKYOU FOR THE ORDER.");
		successPage.printOrderID();
		driver.close();

	}

}
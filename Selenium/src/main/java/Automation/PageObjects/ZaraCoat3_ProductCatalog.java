package Automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class ZaraCoat3_ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ZaraCoat3_ProductCatalog(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".mb-3 button:last-of-type");
	By toast = By.cssSelector(".toast-message");
	By cartButton = By.cssSelector(".btn-custom .fa-shopping-cart");
	By spinner = By.cssSelector(".ngx-spinner-overlay");

	public List<WebElement> GetProductsList() {

		WaitForTheElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement ourProd = products.stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
		return ourProd;
	}

	public ZaraCoat3_CheckOutPage addProductToCart(String productName) throws InterruptedException {
		WebElement ourProd = getProductByName(productName);
		ourProd.findElement(addToCart).click();
		waitForSpinnerToDisappear(spinner);
//		WaitForTheElementToDisappear(spinner);
		Thread.sleep(2000);
		driver.findElement(cartButton).click();
		ZaraCoat3_CheckOutPage checkOutPage = new ZaraCoat3_CheckOutPage(driver);
		return checkOutPage;

	}

}

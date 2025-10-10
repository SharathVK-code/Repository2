package Automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {

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

	public void addProductToCart(String productName) {
		WebElement ourProd = getProductByName(productName);
		ourProd.findElement(addToCart).click();
		WaitForTheElementToDisappear(toast);
		driver.findElement(cartButton).click();
	}

}

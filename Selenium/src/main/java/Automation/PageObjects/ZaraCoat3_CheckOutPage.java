package Automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class ZaraCoat3_CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public ZaraCoat3_CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = "li[class='totalRow'] button")
	WebElement CheckOutButton;

	By headingVisibility = By.cssSelector("h1");

	public Boolean VerifyProductDisplay(String desiredProduct) {
		WaitForTheElementToAppear(headingVisibility); // explicit wait applied
		Boolean flag = cartProducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase(desiredProduct));
		return flag;
	}

	public ZaraCoat3_PaymentPage ClickOnCheckOut() {
		CheckOutButton.click();
		ZaraCoat3_PaymentPage paymentPage = new ZaraCoat3_PaymentPage(driver);
		return paymentPage;

	}

}

package Automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class ZaraCoat3_SuccessPage extends AbstractComponent {

	WebDriver driver;

	public ZaraCoat3_SuccessPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement cnfrmMessage;
	@FindBy(css = "tr td label[class='ng-star-inserted']")
	WebElement totalOrderID;

	By toastElement = By.cssSelector(".toast-success");

	public String validateConfirmMessage() {
		WaitForTheElementToAppear(toastElement);
		String confirmMessage = cnfrmMessage.getText();
		return confirmMessage;
	}

	public void printOrderID() {
		String orderID = totalOrderID.getText().split(" ")[1].split(" ")[0];
		System.out.println("your Order ID is:" + orderID);
//		driver.close();

	}

}

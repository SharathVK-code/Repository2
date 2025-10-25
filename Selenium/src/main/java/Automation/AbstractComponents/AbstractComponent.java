package Automation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.PageObjects.OrdersPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(css = "button[routerlink='/dashboard/']")
	WebElement HomeButton;
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement OrdersButton;
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement CartButton;

	public void ClickOnHomeButton() {
		HomeButton.click();
	}

	public OrdersPage ClickOnOrdersButton() {
		OrdersButton.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}

	public void ClickOnCartButton() {
		CartButton.click();
	}

	public void WaitForTheElementToAppear(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

	}

	public void WaitForTheWebElementToAppear(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));

	}

	public void WaitForTheElementToDisappear(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}
}

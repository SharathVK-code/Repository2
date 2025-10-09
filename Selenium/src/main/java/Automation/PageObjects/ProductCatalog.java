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

	@FindBy(id = ".mb-3")
	List<WebElement> products;

	public List<WebElement> GetProductsList() {

		WaitForTheElementToAppear(By.cssSelector(".mb-3"));
		return products;
	}

}

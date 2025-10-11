package Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class SuccessPage extends AbstractComponent {
	WebDriver driver;

	public SuccessPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}

package Automation.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		String desiredProduct = "ZARA COAT 3";
		// Login Page
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("ambati.sharath500@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("SharathVK@18");
		driver.findElement(By.id("login")).click();

		// Items Page
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement ourProd = products.stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(desiredProduct)).findFirst()
				.orElse(null);
		ourProd.findElement(By.cssSelector(".mb-3 button:last-of-type")).click();
		// Web Driver wait - explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".toast-message"))));
		driver.findElement(By.cssSelector(".btn-custom .fa-shopping-cart")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h1"))));
		driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();

		// checkout page

		driver.close();

	}

}
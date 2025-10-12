package Automation.Tests;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ABC_TheFirstCode {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-message"))));
		driver.findElement(By.cssSelector(".btn-custom .fa-shopping-cart")).click();

		// checkout page
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h1")))); // explicit wait applied
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean flag = cartProducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase(desiredProduct));
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();

		// payment page
		driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input[1]")).sendKeys("789");
		driver.findElement(By.xpath("//div[@class='payment__cc']//div[3]//input")).sendKeys("Sharath");
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));// explicit wait
		driver.findElement(By.cssSelector("section button:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		// success page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-success")));
		String cnfrmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(cnfrmMessage, "THANKYOU FOR THE ORDER.");
		String totalOrderID = driver.findElement(By.cssSelector("tr td label[class='ng-star-inserted']")).getText();
		String orderID = totalOrderID.split(" ")[1].split(" ")[0];
		System.out.println("your Order ID is:" + orderID);

		driver.close();

	}

}
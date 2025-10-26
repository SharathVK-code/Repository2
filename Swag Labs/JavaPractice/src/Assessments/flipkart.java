package Assessments;

import java.util.ArrayList;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class flipkart {

	public static <webDriver> void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com");
//		try {
//			webElement closeLogin = driver.findElement(By.cssSelector("//img[@alt='Mobiles']"));
//			closeLogin.click();
//				
//		}
//		catch (exception e) {
//			System.out.println("Login popup not found or already closed.");
//			
//		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(), 'price -- low to High')]")).click();
		Thread.sleep(5000);
		WebElement firstItem = driver.findElement(By.cssSelector("a._1fQZEK"));
		firstItem.click();
		
		ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(5000);
		WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", addToCartButton);
		System.out.println("Item added to cart");
		
		
		
		
	}

}

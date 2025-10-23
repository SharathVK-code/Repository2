package Automation.Tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import Automation.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18@18");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

}
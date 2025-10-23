package Automation.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Automation.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		landingPage.loginUser("ambati.sharath500@gmail.com", "SharathVK@18@18");

	}

}
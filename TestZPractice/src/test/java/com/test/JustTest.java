package com.test;

import org.testng.annotations.Test;

import basePackage.Drivers;
import pageObjects.AddressPage;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.PlaceOrder;
import pageObjects.ProductCatalogue;
import pageObjects.ThankYouPage;

public class JustTest extends Drivers {

	@Test
	void testing() {

		// Drivers.driverMethod();
		LandingPage.goTo();
		LandingPage.unMethod("qaindia50@gmail.com");
		LandingPage.psMethod("Primo405$");
		LandingPage.loginMethod();
		ProductCatalogue.toast();
		ProductCatalogue.itemList("adidas original");
		CartPage.ClickOnCart();
		AddressPage.checkProductList("adidas original");
		PlaceOrder.userName("qaindia@gmail.com");
		PlaceOrder.country("ind");
		PlaceOrder.placeOrderC();
		ThankYouPage.getOrderID(" dummywebsite@rahulshettyacademy.com ");
		Drivers.tearDown();
		System.out.println("TC Done and git added");
	}
}

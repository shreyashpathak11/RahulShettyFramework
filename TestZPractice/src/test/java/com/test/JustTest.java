package com.test;

import org.testng.annotations.Test;

import basePackage.Drivers;

public class JustTest extends Drivers {

	@Test
	void testing() {

		lp.unMethod("qaindia50@gmail.com");
		lp.psMethod("Primo405$");
		pc = lp.loginMethod();
		pc.toast();
		atc = pc.itemList("adidas original");
		cp = atc.ClickOnCart();
		po = cp.checkProductList("adidas original");
		po.userName("qaindia@gmail.com");
		po.country("ind");
		tp = po.placeOrderC();
		tp.getOrderID(" dummywebsite@rahulshettyacademy.com ");

	}
}

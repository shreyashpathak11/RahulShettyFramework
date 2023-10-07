package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pageObjects.*;

public class Drivers {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeSuite
	public void driverMethod() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		LandingPage lPage = new LandingPage(driver, wait);
		ProductCatalogue pp = new ProductCatalogue(driver, wait);
		CartPage cp = new CartPage(driver, wait);
		AddressPage ap = new AddressPage(driver, wait);
		PlaceOrder poOrder = new PlaceOrder(driver, wait);
		ThankYouPage thPage = new ThankYouPage(driver, wait);

	}

	@AfterSuite
	public static void tearDown() {

		driver.quit();
	}

}

package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pageObjects.CartPage;
import pageObjects.AddToCart;
import pageObjects.LandingPage;
import pageObjects.PlaceOrder;
import pageObjects.ProductCatalogue;
import pageObjects.ThankYouPage;

public class Drivers {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public LandingPage lp;
	public ProductCatalogue pp;
	public AddToCart atc;
	public CartPage cp;
	public PlaceOrder po;
	public ThankYouPage tp;

	@BeforeSuite
	public LandingPage driverMethod() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println("Hello");

		lp = new LandingPage(driver, wait);
		pp = new ProductCatalogue(driver, wait);
		atc = new AddToCart(driver, wait);
		cp = new CartPage(driver, wait);
		po = new PlaceOrder(driver, wait);
		tp = new ThankYouPage(driver, wait);

		return lp;

	}

	@AfterSuite
	public static void tearDown() {

		driver.quit();
	}

}

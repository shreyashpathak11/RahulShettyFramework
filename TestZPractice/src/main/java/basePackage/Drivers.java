package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pageObjects.AddToCart;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.PlaceOrder;
import pageObjects.ProductCatalogue;
import pageObjects.ThankYouPage;

public class Drivers {

	public ChromeOptions options;
	public WebDriver driver;
	public WebDriverWait wait;
	public LandingPage lp;
	public ProductCatalogue pc;
	public AddToCart atc;
	public CartPage cp;
	public PlaceOrder po;
	public ThankYouPage tp;

	@BeforeClass
	public LandingPage driverMethod() {

		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");

		lp = new LandingPage(driver, wait);
		pc = new ProductCatalogue(driver, wait);
		atc = new AddToCart(driver, wait);
		cp = new CartPage(driver, wait);
		po = new PlaceOrder(driver, wait);
		tp = new ThankYouPage(driver, wait);

		return new LandingPage(driver, wait);

	}

	@AfterClass
	public void terDown() {

		driver.quit();
	}

}

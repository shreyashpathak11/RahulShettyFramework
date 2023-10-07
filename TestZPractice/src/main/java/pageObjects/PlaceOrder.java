package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class PlaceOrder {

	WebDriver driver;
	static WebDriverWait wait;

	public PlaceOrder(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		PlaceOrder.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@type='text' and contains(@class,'text-validated') and contains(@class,'ng-valid')]")
	static WebElement signInEmail;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	static WebElement countryField;

	@FindBy(xpath = "//button[@type='button']//span")
	static List<WebElement> country;

	@FindBy(xpath = "//a[contains(@class,'btnn')]")
	static WebElement placeOrderButton;

	public static void userName(String un) {

		signInEmail.sendKeys(un);
	}

	public static void country(String countryName) {

		countryField.sendKeys(countryName);

		for (int i = 0; i < country.size(); i++) {
			wait.until(ExpectedConditions.visibilityOfAllElements(country));

			if (country.get(i).getText().equals("India")) {

				country.get(i).click();

				break;

			}
		}
	}

	public static void placeOrderC() {

		wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
		placeOrderButton.click();

	}

}

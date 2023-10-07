package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class PlaceOrder extends Drivers {

	WebDriver driver;
	WebDriverWait wait;

	public PlaceOrder(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@type='text' and contains(@class,'text-validated') and contains(@class,'ng-valid')]")
	WebElement signInEmail;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryField;

	@FindBy(xpath = "//button[@type='button']//span")
	List<WebElement> country;

	@FindBy(xpath = "//a[contains(@class,'btnn')]")
	WebElement placeOrderButton;

	public void userName(String un) {

		signInEmail.sendKeys(un);
	}

	public void country(String countryName) {

		countryField.sendKeys(countryName);

		for (int i = 0; i < country.size(); i++) {
			wait.until(ExpectedConditions.visibilityOfAllElements(country));

			if (country.get(i).getText().equals("India")) {

				country.get(i).click();

				break;

			}
		}
	}

	public ThankYouPage placeOrderC() {

		wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
		placeOrderButton.click();

		return new ThankYouPage(driver, wait);

	}

}

package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class CartPage extends Drivers {

	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> cartList;

	@FindBy(xpath = "//li[@class='totalRow']//button[@class='btn btn-primary']")
	WebElement checkOut;

	public PlaceOrder checkProductList(String productName) {

		boolean match = cartList.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));

		if (match) {

			wait.until(ExpectedConditions.elementToBeClickable(checkOut));
			checkOut.click();
		}

		return po;

	}

}

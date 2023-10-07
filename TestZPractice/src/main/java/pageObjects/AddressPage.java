package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class AddressPage {

	WebDriver driver;
	static WebDriverWait wait;

	public AddressPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		AddressPage.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	static List<WebElement> cartList;

	@FindBy(xpath = "//li[@class='totalRow']//button[@class='btn btn-primary']")
	static WebElement checkOut;

	public static void checkProductList(String productName) {

		boolean match = cartList.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));

		if (match) {

			wait.until(ExpectedConditions.elementToBeClickable(checkOut));
			checkOut.click();
		}

	}

}

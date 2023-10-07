package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class AddToCart extends Drivers {

	WebDriver driver;
	WebDriverWait wait;

	public AddToCart(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;

	public CartPage ClickOnCart() {

		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		cartButton.click();

		return new CartPage(driver, wait);

	}

}

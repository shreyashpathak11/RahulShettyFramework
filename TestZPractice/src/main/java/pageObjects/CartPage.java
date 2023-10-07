package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;
	static WebDriverWait wait;

	public CartPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	static
	WebElement cartButton;

	public static void ClickOnCart() {

		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		cartButton.click();

	}

}

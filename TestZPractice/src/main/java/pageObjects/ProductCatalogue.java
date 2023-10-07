package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class ProductCatalogue {

	static WebDriver driver;
	static WebDriverWait wait;

	public ProductCatalogue(WebDriver driver, WebDriverWait wait) {

		ProductCatalogue.driver = driver;
		ProductCatalogue.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "toast-container")
	static WebElement toast;

	@FindBy(xpath = "//h5//b")
	static List<WebElement> itemList;

	@FindBy(xpath = "//button[@class='btn w-10 rounded']")
	static List<WebElement> addButton;

	@FindBy(className = "ng-animating")
	static WebElement animation;

	public static void toast() {

		wait.until(ExpectedConditions.visibilityOf(toast));
		toast.click();
		// wait.until(ExpectedConditions.invisibilityOf(animation));

	}

	public static void itemList(String productName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(itemList));

		for (int i = 0; i < itemList.size(); i++) {

			String name = itemList.get(i).getText();

			if (name.equalsIgnoreCase(productName)) {

				addButton.get(i).click();

			}

		}

	}

}

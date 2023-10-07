package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class ThankYouPage extends Drivers {

	WebDriver driver;
	WebDriverWait wait;

	public ThankYouPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".em-spacer-1 label[class= ng-star-inserted]")
	WebElement order;

	@FindBy(xpath = "//td[@class='links']")
	WebElement dummy;

	@FindBy(xpath = "//td[@class='links']")
	WebElement actual;

	public void getOrderID(String trim) {

		wait.until(ExpectedConditions.visibilityOf(dummy));
		String expected = trim.trim();

		String actualString = actual.getText();

	}

}

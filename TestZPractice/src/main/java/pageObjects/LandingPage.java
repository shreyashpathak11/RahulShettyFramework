package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.Drivers;

public class LandingPage extends Drivers {

	WebDriver driver;
	WebDriverWait wait;

	public LandingPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement un;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement ps;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginButton;

	public void unMethod(String username) {

		wait.until(ExpectedConditions.visibilityOf(un));
		un.sendKeys(username);

	}

	public void psMethod(String password) {
		wait.until(ExpectedConditions.visibilityOf(ps));
		ps.sendKeys(password);

	}

	public ProductCatalogue loginMethod() {

		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();

		return pp;

	}

}

package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	static WebDriver driver;
	static WebDriverWait wait;

	public LandingPage(WebDriver driver, WebDriverWait wait) {

		LandingPage.driver = driver;
		LandingPage.wait = wait;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='userEmail']")
	static WebElement un;

	@FindBy(xpath = "//input[@id='userPassword']")
	static WebElement ps;

	@FindBy(xpath = "//input[@id='login']")
	static WebElement loginButton;

	public static void unMethod(String username) {

		wait.until(ExpectedConditions.visibilityOf(un));
		un.sendKeys(username);

	}

	public static void psMethod(String password) {
		wait.until(ExpectedConditions.visibilityOf(ps));
		ps.sendKeys(password);

	}

	public static void loginMethod() {

		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();

	}

	public static void goTo() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://rahulshettyacademy.com/client";

		driver.get(url);

	}

}

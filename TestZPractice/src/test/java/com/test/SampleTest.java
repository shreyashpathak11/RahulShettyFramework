package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SampleTest {

	@Test
	void simple() {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://rahulshettyacademy.com/client";

		driver.get(url);

		WebElement register = driver.findElement(By.xpath("//p[@class='login-wrapper-footer-text']"));
		register.click();

		WebElement fn = driver.findElement(By.id("firstName"));
		fn.sendKeys("Qaindia");

		WebElement ln = driver.findElement(By.id("lastName"));
		ln.sendKeys("Fifty");

		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("qaindia50@gmail.com");

		WebElement phone = driver.findElement(By.id("userMobile"));
		phone.sendKeys("9191912244");

		WebElement occupation = driver.findElement(By.xpath("//select[@formcontrolname='occupation']"));
		Select select = new Select(occupation);
		select.selectByVisibleText("Engineer");

		WebElement gender = driver.findElement(By.xpath("//input[@value='Male']"));
		gender.click();

		WebElement pass = driver.findElement(By.id("userPassword"));
		pass.sendKeys("Primo405$");

		WebElement confPass = driver.findElement(By.id("confirmPassword"));
		confPass.sendKeys("Primo405$");

		WebElement required = driver.findElement(By.xpath("//input[@formcontrolname='required']"));
		required.click();

		WebElement registerButton = driver.findElement(By.xpath("//input[@type='submit']"));
		registerButton.click();

		// driver.close();

	}

}

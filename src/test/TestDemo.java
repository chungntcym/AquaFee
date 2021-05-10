package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo extends TestDriver {

	ChromeDriver driver = getDriver();

	@Test
	public void login_title_test() {
		driver.get("http://localhost:8080/AquaFee");
		String title = driver.getTitle();
		String expectedTitle = "Sign in";
		driver.close();
		assertEquals(expectedTitle, title, "Title not as expected");
	}

	@Test
	public void login_as_admin_test() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();

		// Check if login successfully, if not the title will not be same as expected
		String title = driver.getTitle();
		String expectedTitle = "AquaFee";
		driver.close();
		assertEquals(expectedTitle, title, "Title not as expected");
	}

}

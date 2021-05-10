package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Works\\AquaFee\\browserdriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/AquaFee");
		
		String title = driver.getTitle();
		String expectedTitle = "AquaFee";
		
		if(expectedTitle.contentEquals(title)) {
			System.out.print("Test Passed");
		}
		else {
			System.out.print("Test Failed");
		}
		
		//Fill username and password sequentially with admin and admin 
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		//Click login button
		driver.findElement(By.id("btn_login")).click();
		
		//Wait for 2 seconds
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//Back to previous page
		driver.navigate().back();
		
		//Fill username and password sequentially with user and user 
		username = driver.findElement(By.name("username"));
		username.sendKeys("user");
		password = driver.findElement(By.name("password"));
		password.sendKeys("user");
	}

}

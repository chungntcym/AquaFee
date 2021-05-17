package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestGrade extends TestDriver {

	ChromeDriver driver = getDriver();

	@Test
	public void test_ch_bg_bsn_01() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		//Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		//Gia bac 1 la 1000, bac 2 la 5000, bac 3 la 9000
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		inputField.clear();
		inputField.sendKeys("1000");
		inputField = driver.findElement(By.xpath("(//input[@name='price'])[2]"));
		inputField.clear();
		inputField.sendKeys("5000");
		inputField = driver.findElement(By.xpath("(//input[@name='price'])[3]"));
		inputField.clear();
		inputField.sendKeys("9000");
		//Nguong bac 2 la 3, bac 3 la 9
		inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
		inputField.clear();
		inputField.sendKeys("3");
		inputField = driver.findElement(By.xpath("(//input[@name='value'])[3]"));
		inputField.clear();
		inputField.sendKeys("9");
		
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		
		String url = driver.getCurrentUrl();
		
//		driver.close();
//		assertEquals(expectedTitle, title, "Title not as expected");
	}
	
	


}

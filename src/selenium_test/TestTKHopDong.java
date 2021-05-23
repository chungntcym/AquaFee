package selenium_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class TestTKHopDong extends TestDriver{

	ChromeDriver driver = getDriver();
	
	@Test
	public void Test_number_of_Contract() {
		driver.get("http://localhost:8080/AquaFee");
		
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1");
		driver.findElement(By.id("btn_login")).click();
		driver.findElement(By.id("TK_Contract")).click();
		Select drpDistrict = new Select(driver.findElement(By.id("district-select")));
		drpDistrict.selectByVisibleText("Hà Đông");
		Select drpSubDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		drpSubDistrict.selectByVisibleText("Mộ Lao");
		//driver.findElement(By.id("show-invoice")).click();
		String total = driver.findElement(By.id("total")).getText();
		String expectedTotal = "Có tổng cộng 1 bản ghi";
		driver.close();
		assertEquals(total, expectedTotal);
	}	

	@Test
	public void Test_No_Contract() {
		driver.get("http://localhost:8080/AquaFee");
		
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1");
		driver.findElement(By.id("btn_login")).click();
		driver.findElement(By.id("TK_Contract")).click();
		Select drpDistrict = new Select(driver.findElement(By.id("district-select")));
		drpDistrict.selectByVisibleText("Hà Đông");
		Select drpSubDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		drpSubDistrict.selectByVisibleText("Phú La");
		//driver.findElement(By.id("show-invoice")).click();
		String total = driver.findElement(By.id("notification")).getText();
		String expectedTotal = "Không có khách hàng nào tại địa chỉ đã chọn";
		driver.close();
		assertEquals(total, expectedTotal);
	}	

}

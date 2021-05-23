package selenium_test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSendMail extends TestDriver {

	ChromeDriver driver = getDriver();

	@Test
	public void login_as_admin_test() {
		driver.get("http://localhost:8080/AquaFee");
		
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1");
		
		// Click login button
		driver.findElement(By.id("btn_login")).click();

		//Check if login successfully, if not the title will not be same as expected
		String title = driver.getTitle();
		String expectedTitle = "Aquaman - Quản lý";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void choose_send_email() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChinhNVQuanly.jsp");
		String title = driver.getTitle();
		String expectedTitle = "Aquaman - Quản lý";
		driver.findElement(By.id("sendEmail")).click();
		title = driver.getTitle();
		expectedTitle = "Chọn khu vực dân cư";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void choose_district() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		String title = driver.getTitle();
		String expectedTitle = "Chọn hộ dân";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void choose_customer() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		String title = driver.getTitle();
		String expectedTitle = "Chọn loại tin cần gửi";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void select_send_bill() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		WebElement radio = driver.findElement(By.id("0"));
		radio.click();
		String title = driver.getTitle();
		String expectedTitle = "Soạn tin nhắn";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void select_send_cutNoti() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		WebElement radio = driver.findElement(By.id("1"));
		radio.click();
		String title = driver.getTitle();
		String expectedTitle = "Soạn tin nhắn";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void select_send_CustomMess() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		WebElement radio = driver.findElement(By.id("2"));
		radio.click();
		String title = driver.getTitle();
		String expectedTitle = "Soạn tin nhắn";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void send_bill() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		WebElement radio = driver.findElement(By.id("0"));
		radio.click();
		driver.findElement(By.name("send-email")).click();
		String title = driver.getTitle();
		String expectedTitle = "Aquaman - Quản lý";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void send_cuttime() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		WebElement radio = driver.findElement(By.id("1"));
		radio.click();
		WebElement timeIn = driver.findElement(By.id("timein"));
		WebElement dateIn = driver.findElement(By.id("date-input"));
		WebElement timeOut = driver.findElement(By.id("timeout"));
		WebElement dateOut = driver.findElement(By.id("date-output"));
		timeIn.sendKeys("00:01");
		timeOut.sendKeys("01:01");
		dateIn.sendKeys("24052021");
		dateOut.sendKeys("25052021");
		driver.findElement(By.name("send-email")).click();
		String title = driver.getTitle();
		String expectedTitle = "Aquaman - Quản lý";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	@Test
	public void send_Custom() {
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonKhuVucTimKiem.jsp");
		Select district = new Select(driver.findElement(By.id("district-select")));
		district.selectByVisibleText("Hà Đông");
		Select subDistrict = new Select(driver.findElement(By.id("subdistrict-select")));
		subDistrict.selectByVisibleText("Mộ Lao");
		WebElement checkbox = driver.findElement(By.id("check_all"));
		checkbox.click();
		driver.findElement(By.id("soantin")).click();
		WebElement radio = driver.findElement(By.id("2"));
		radio.click();
		WebElement textArea = driver.findElement(By.id("message-1"));
		textArea.sendKeys("Test Selenium Here");
		driver.findElement(By.name("send-email")).click();
		String title = driver.getTitle();
		String expectedTitle = "Aquaman - Quản lý";
		driver.close();
		assertEquals(title, expectedTitle);
	}
	

}
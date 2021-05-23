package selenium_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dao.GradeDAO;
import model.Grade;

public class TestGrade extends TestDriver {

	ChromeDriver driver = getDriver();

	@Test
	public void testGradeInsert() throws SQLException {
		GradeDAO gradeDao = new GradeDAO();

		Connection connection = gradeDao.getDAOConnection();
		try {
			driver.get("http://localhost:8080/AquaFee");
			// Fill username and password sequentially with admin and admin
			WebElement username = driver.findElement(By.name("username"));
			username.sendKeys("admin");
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("admin");
			// Click login button
			driver.findElement(By.id("btn_login")).click();
			// Chon ho ngheo
			driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
			Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
			householdTypeSelect.selectByValue("1");
			// Gia bac 1 la 1000, bac 2 la 5000, bac 3 la 9000
			WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
			inputField.clear();
			inputField.sendKeys("1000");
			inputField = driver.findElement(By.xpath("(//input[@name='price'])[2]"));
			inputField.clear();
			inputField.sendKeys("5000");
			inputField = driver.findElement(By.xpath("(//input[@name='price'])[3]"));
			inputField.clear();
			inputField.sendKeys("9000");
			// Nguong bac 2 la 3, bac 3 la 9
			inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
			inputField.clear();
			inputField.sendKeys("3");
			inputField = driver.findElement(By.xpath("(//input[@name='value'])[3]"));
			inputField.clear();
			inputField.sendKeys("9");

			driver.findElement(By.xpath("(//button[@type='submit'])")).click();

			driver.close();

			connection.setAutoCommit(false);

			Date date = new Date();
			java.sql.Timestamp startDate = new java.sql.Timestamp(date.getTime());

			// Fake data
			ArrayList<Grade> listGradeTest = new ArrayList<>();
			listGradeTest.add(new Grade(0, 1, 0, 1000, startDate));
			listGradeTest.add(new Grade(0, 2, 3, 5000, startDate));
			listGradeTest.add(new Grade(0, 3, 9, 9000, startDate));

			ArrayList<Grade> listGradeResult;

			listGradeResult = gradeDao.getTableGradeByContractTypeId("1");

			// If pass => both create and read function work normally
			assertEquals(listGradeTest, listGradeResult);

		} finally {
			connection.rollback();
			connection.close();
		}
	}

	@Test
	public void testGradeNegativePrice() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Gia bac 1 la -1000
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		inputField.clear();
		inputField.sendKeys("-1000");

		String expectedValue = "1000";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertEquals(expectedValue, realValue);
	}

	@Test
	public void testGradeDecimalPrice() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Gia bac 1 la -1000
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		inputField.clear();
		inputField.sendKeys("1000.456");

		String expectedValue = "1000456";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertEquals(expectedValue, realValue);
	}

	@Test
	public void testGradeNegativeValue() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Nguong bac 2 la 3, bac 3 la 9
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
		inputField.clear();
		inputField.sendKeys("-3");

		String expectedValue = "3";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertEquals(expectedValue, realValue);
	}

	@Test
	public void testGradeBigValue() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Nguong bac 2 la 3, bac 3 la 9
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
		inputField.clear();
		inputField.sendKeys("2147483648");

		String expectedValue = "2147483648";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertTrue(!expectedValue.equals(realValue));
	}

	@Test
	public void testGradeBigPrice() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Gia bac 1 la -1000
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		inputField.clear();
		inputField.sendKeys("340282346638528859811704183484516925441");

		String expectedValue = "340282346638528859811704183484516925441";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertTrue(!expectedValue.equals(realValue));
	}

	@Test
	public void testGradeWordPrice() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Gia bac 1 la -1000
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		inputField.clear();
		inputField.sendKeys("abcasc");

		String expectedValue = "";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertEquals(expectedValue, realValue);
	}

	@Test
	public void testGradeWordValue() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Nguong bac 2 la 3, bac 3 la 9
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
		inputField.clear();
		inputField.sendKeys("abcd");

		String expectedValue = "";

		String realValue = inputField.getAttribute("value");

		driver.close();

		assertEquals(expectedValue, realValue);
	}

	@Test
	public void testGradeSortingByValue() {
		driver.get("http://localhost:8080/AquaFee");
		// Fill username and password sequentially with admin and admin
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		// Click login button
		driver.findElement(By.id("btn_login")).click();
		// Chon ho ngheo
		driver.get("http://localhost:8080/AquaFee/view/ql/GDChonLoaiHopDong.jsp");
		Select householdTypeSelect = new Select(driver.findElement(By.id("contract-type-select")));
		householdTypeSelect.selectByValue("1");
		// Gia bac 1 la 10000, bac 2 la 1000, bac 3 la 7000
		WebElement inputField = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		inputField.clear();
		inputField.sendKeys("10000");
		inputField = driver.findElement(By.xpath("(//input[@name='price'])[2]"));
		inputField.clear();
		inputField.sendKeys("1000");
		inputField = driver.findElement(By.xpath("(//input[@name='price'])[3]"));
		inputField.clear();
		inputField.sendKeys("7000");
		// Nguong bac 2 la 3, bac 3 la 9
		inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
		inputField.clear();
		inputField.sendKeys("10");
		inputField = driver.findElement(By.xpath("(//input[@name='value'])[3]"));
		inputField.clear();
		inputField.sendKeys("5");
		inputField = driver.findElement(By.xpath("(//input[@name='value'])[2]"));
		inputField.click();

		ArrayList<String> listExpectedValue = new ArrayList<>();
		listExpectedValue.add("5");
		listExpectedValue.add("10");
		
		ArrayList<String> listRealValue = new ArrayList<>();
		listRealValue.add(driver.findElement(By.xpath("(//input[@name='value'])[2]")).getAttribute("value"));
		listRealValue.add(driver.findElement(By.xpath("(//input[@name='value'])[3]")).getAttribute("value"));

		driver.close();

		assertEquals(listExpectedValue, listRealValue);
	}

}

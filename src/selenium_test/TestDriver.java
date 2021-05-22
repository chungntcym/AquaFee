package selenium_test;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	private String driverUrl = "C:\\Users\\Admin\\Downloads\\chromedriver.exe";

	public TestDriver() {
	}

	public ChromeDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", driverUrl);
		return new ChromeDriver();
	}
}

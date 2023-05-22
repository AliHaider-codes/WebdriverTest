package test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {
	protected WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

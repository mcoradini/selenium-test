package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestStart {

	protected static WebDriver driver;

	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marco/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
	}

	@After
	public void cleanUp(){
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void tearDown(){
		driver.close();
		driver.quit();
	}
}

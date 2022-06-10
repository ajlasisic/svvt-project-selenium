package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SignInTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https:\\www.booking.com";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@Test
	void testSignIn() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[6]/a"));		
		signInButton.click();
		
		WebElement email = webDriver.findElement(By.name("username"));		
		email.sendKeys("ajla.sisic19@gmail.com");
		
		WebElement button = webDriver.findElement(By.cssSelector("#root > div > div > div.app > div.access-conta"
				+ "iner.bui_font_body > div > div > div > div > div > div > form > div:nth-child(3) > button"));		
		button.click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));	
		password.sendKeys("Testing123");
		
		WebElement signin = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/form/button"));		
		signin.click();	
	}
}

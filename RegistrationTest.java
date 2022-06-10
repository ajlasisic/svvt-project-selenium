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

class RegistrationTest {
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
	void testRegistration() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebElement register = webDriver.findElement(By.cssSelector("#b2indexPage > header > nav.bui-header__bar > div.bui-g"
				+ "roup.bui-button-group.bui-group--inline.bui-group--align-end.bui-group--vertical-align-middle > div:nth-child(5) > a"));		
		register.click();
		
		WebElement enterEmail = webDriver.findElement(By.name("username"));		
		enterEmail.sendKeys("ajla.sisic00@gmail.com");
		
		WebElement button = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/di"
				+ "v/div/div/div/form/div[3]/button"));		
		button.click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_password")));	
		password.sendKeys("Testing123");
		
		WebElement confirm_password = webDriver.findElement(By.name("confirmed_password"));		
		confirm_password.sendKeys("Testing123");
		
		WebElement create = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/form/button"));		
		create.click();
}
}

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class EditUser {
	private static WebDriver webDriver;
	private static String baseUrl;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\Chrome Driver\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https:\\www.booking.com";
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}
	
	@Test
	void testManageAccount() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[6]/a"));		
		signInButton.click();
		
		WebElement email = webDriver.findElement(By.name("username"));		
		email.sendKeys("ajla.sisic00@gmail.com");
		
		WebElement button = webDriver.findElement(By.cssSelector("#root > div > div > div.app > div.access-conta"
				+ "iner.bui_font_body > div > div > div > div > div > div > form > div:nth-child(3) > button"));		
		button.click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));	
		password.sendKeys("Testing123");
		
		WebElement signin = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/form/button"));		
		signin.click();	
		Thread.sleep(4000);
		
		WebElement popup = webDriver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/div[12]/button"));
		popup.click();
		
		WebElement user = webDriver.findElement(By.xpath("/html/body/header/nav[1]/div[2]/div[6]/div/a/span/div/div[2]/span[1]"));
		user.click();
		WebElement edit = webDriver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[6]/div/div/div/ul/li[1]/a/span[2]"));
		edit.click();
		Thread.sleep(3000);
		
		WebElement personal = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/nav/ul/li[1]/a/div/h2"));
		personal.click();
		Thread.sleep(2000);
		
		WebElement editButton = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div[2]/div[1]/div/div[1]/button/span"));
		editButton.click();
		Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"065fea44-026c-4118-937b-eb5cd77b488b_titleSelect\"]")));
		select.selectByVisibleText("Mrs.");
		WebElement save = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div[2]/div[1]/div/div[2]/form/div[2]/div/button/span"));
		save.click();
		Thread.sleep(2000);
	}
	
}

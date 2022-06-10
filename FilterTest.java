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

class FilterTest {
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
	void testFilters() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebElement where = webDriver.findElement(By.id("ss"));
		where.sendKeys("Sarajevo");
		WebElement when = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span"));
		when.click();

		WebElement from = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[4]/td[5]"));
		from.click();
		WebElement until = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[4]/td[7]"));
		until.click();
		Thread.sleep(1000);
		WebElement search = webDriver.findElement(By.cssSelector("#frm > div.xp__fieldset.js--sb-fieldset.accommodation > div.xp__but"
				+ "ton > div.sb-searchbox-submit-col.-submit-button > button"));
		search.click();
	
	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	WebElement parking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchboxInc\"]/div[1]/div/div/di"
			+ "v[1]/div[3]/div[2]/label/div")));
	parking.click();
	
	WebElement free = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchboxInc\"]/div[1]/div/div/div[1]/d"
			+ "iv[3]/div[9]/label/div")));
	free.click();
	
	WebElement neighborhood = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchboxInc\"]/div[1]/div/div/di"
			+ "v[1]/div[20]/div[2]/label/div")));
	neighborhood.click();
	
	WebElement stars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajaxsrwrap\"]/div[2]/div/div/div[2]/ul/li[5]/a")));
	stars.click();
}
}

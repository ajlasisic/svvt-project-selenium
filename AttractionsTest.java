package test;

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

class AttractionsTest {
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
	void testAttractions() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		WebElement attractions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#b2indexPa"
				+ "ge > header > nav.bui-tab.bui-header__tab.bui-tab--bo"
				+ "rderless.bui-tab--light.bui-tab--rounded > ul > li:nth-child(4) > a")));		
		attractions.click();
		
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/di"
				+ "v[1]/div[1]/div/div[2]/div/div[3]/div/div[1]/form/div/input")));		
		search.sendKeys("Amsterdam");
		Thread.sleep(2000);
		
		WebElement button = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div"
				+ "/div[2]/div/div[3]/div/div[1]/form/button"));		
		button.click();
		Thread.sleep(2000);
		
        WebElement filter1 =webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/di"
        		+ "v[2]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[2]/label/div/div/span[1]"));		
		filter1.click();
		
		WebElement museum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[3]/div[1]/di"
				+ "v/div/div[1]/div/div/a/div[2]/div[1]/div[1]/div/h4")));		
		museum.click();
		
		WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/di"
				+ "v/div/div/form/div[2]/div[2]/div")));	
		date.click();
		
		WebElement pickdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/div/di"
				+ "v/form/div[2]/div[2]/div[2]/div/div/div/div/table/tbody/tr[5]/td[7]")));		
		pickdate.click();
		
		WebElement select = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div/div/di"
				+ "v/form/div[4]/div/div/div/div[3]/div[2]/button")));		
		select.click();
		
		WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[5]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/button[2]")));	
		number.click();
		
		WebElement next = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/div/div/fo"
				+ "rm/div[5]/div/div/div/div[3]/div[2]/button"));		
		next.click();
		
		Thread.sleep(5000);
	}
}

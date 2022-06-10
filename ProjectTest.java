package test;

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

class ProjectTest {
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
	void testHotelFinding() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		WebElement where = webDriver.findElement(By.id("ss"));
		where.sendKeys("Hilton Beograd");
		WebElement when = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span"));
		when.click();
		WebElement arrow = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]"));
		arrow.click();
		WebElement from = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[5]"));
		from.click();
		WebElement until = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[3]/td[5]"));
		until.click();
		Thread.sleep(1000);
		WebElement search = webDriver.findElement(By.cssSelector("#frm > div.xp__fieldset.js--sb-fieldset.accommodation > div.xp__but"
				+ "ton > div.sb-searchbox-submit-col.-submit-button > button"));
		search.click();
		Thread.sleep(3000);
		WebElement button = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[1]/div[4]/di"
				+ "v[4]/div[1]/div/div/div/div[5]/div[4]/div[1]/div[2]/div/div[3]/div/div[2]/div/div[2]/div/a"));		
		button.click();
		Thread.sleep(1000); 
		
		ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles()); 
		webDriver.switchTo().window(tabs2.get(0)); 
		webDriver.close(); 
		webDriver.switchTo().window(tabs2.get(1));
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		//WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hprt-table\"]/thead/tr/th[1]")));
		
		Select numberOfRooms = new Select(webDriver.findElement(By.name("nr_rooms_307944004_112430347_2_2_0")));
		numberOfRooms.selectByValue("1"); 
		
		WebElement reserve = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[1]/div/div[6]/di"
				+ "v/div[6]/div[3]/div/form/div[26]/div[2]/div[4]/div[6]/button"));
		reserve.click();
		
		WebElement firstname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));		
		firstname.sendKeys("Ajla");
		
		WebElement lastname = webDriver.findElement(By.id("lastname"));
		lastname.sendKeys("Sisic");
		
		WebElement email = webDriver.findElement(By.id("email"));
		email.sendKeys("ajla.sisic19@gmail.com");
		
		WebElement email_confirm = webDriver.findElement(By.id("email_confirm"));
		email_confirm.sendKeys("ajla.sisic19@gmail.com");
		
		WebElement main_guest = webDriver.findElement(By.xpath("//*[@id=\"bp-control-group--notstayer\"]/div/div[1]/div/label/span"));
		main_guest.click();
		
		WebElement fullname = webDriver.findElement(By.id("guest_name_307944004_112430347_2_2_0"));
		fullname.sendKeys("Ajla Adi");
		
		WebElement end = webDriver.findElement(By.name("book"));
		end.click();
		Thread.sleep(2000);
	}
}

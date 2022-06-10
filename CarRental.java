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

class CarRental {
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
	void testCarRental() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebElement tab = webDriver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[2]/ul/li[3]/a"));
		tab.click();
		WebElement driverAge = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/label/span[1]"));
		driverAge.click();
		
		WebElement driverAgeInput = webDriver.findElement(By.id("driverAgeInput"));
		driverAgeInput.sendKeys("21");
	
		WebElement pickup = webDriver.findElement(By.id("ss_origin"));
		pickup.sendKeys("Sarajevo Airport, Bosnia and Herzegovina");
		
		WebDriverWait  wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		WebElement pick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/di"
				+ "v/div/form/div[2]/div[1]/div/div[1]/ul[1]/li")));
		pick.click();
		
		WebElement press = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div/form/div[2]/di"
				+ "v[3]/div/div[2]/div/div/div/div[1]/div/button"));
		press.click();
		
		WebElement from = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[3]/div/div[2]/div/div/di"
				+ "v/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[2]/td[5]"));
		from.click();
		
		WebElement to = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[3]/div/div[3]/div/di"
				+ "v[2]/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[2]/td[7]"));
		to.click();
		
		WebElement search = webDriver.findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[4]/div[2]/button"));
		search.click();
		
		WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"aircon-filter-content\"]/li[2]/label")));
		box.click();
		WebElement car = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[2]/div[11]/div[1]/div[2]/div[1]/div/p/a")));
		car.click();
		
		ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles()); 
		webDriver.switchTo().window(tabs.get(0)); 
		webDriver.close(); 
		webDriver.switchTo().window(tabs.get(1));
		
		WebElement book = webDriver.findElement(By.xpath("//*[@id=\"bookCta\"]"));
		book.click();
		
		WebElement details =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div[3]"
				+ "/div[2]/div/div[2]/form/div[3]/h2")));
		
		Select title = new Select(webDriver.findElement(By.xpath("//*[@id=\"title\"]")));
		title.selectByVisibleText("Mr");
		Thread.sleep(1000);
		
		WebElement fname = webDriver.findElement(By.xpath("//*[@id=\"f_name_input\"]"));
		fname.sendKeys("Adi");
		WebElement lname = webDriver.findElement(By.xpath("//*[@id=\"surname_input\"]"));
		lname.sendKeys("Ajla");
		WebElement email = webDriver.findElement(By.xpath("//*[@id=\"booking-form-email\"]"));
		email.sendKeys("ajla.sisic@stu.ibu.edu.ba");
		WebElement phone = webDriver.findElement(By.xpath("//*[@id=\"phone_input\"]"));
		phone.sendKeys("061234567");
		
		WebElement save = webDriver.findElement(By.xpath("//*[@id=\"mailingList_input\"]"));
		save.click();
		Thread.sleep(2000);
		
		WebElement finish = webDriver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[2]/div/div[2]/form/div[7]/div[1]/button"));
		finish.click();
		Thread.sleep(3000);
	}
}

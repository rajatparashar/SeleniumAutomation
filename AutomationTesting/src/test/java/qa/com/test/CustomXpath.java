package qa.com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CustomXpath {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "/home/rajat/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		WebElement searchBox;		
		/*
		 * 1. contains
		 * id = 123_test_234
		 * id = 345_test_456
		 * id = 678_test_890
		 * 
		 * 2. starts-with
		 * id = test_123
		 * id = test_456
		 * id = test_789
		 * 
		 * 3. ends-with
		 * id = 123_test_t
		 * id = 456_test_t
		 * id = 567_test_t
		 */
		
		//searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
		//searchBox = driver.findElement(By.xpath("//input[@name='_nkw']"));
		//searchBox = driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]"));
		searchBox = driver.findElement(By.xpath("//input[starts-with(@id,'gh-ac')]"));
		searchBox.sendKeys("Java");		
	}
}
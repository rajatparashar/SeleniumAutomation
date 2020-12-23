package qa.com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver","/home/rajat/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@role='button' and @data-testid]")).click();
		// handle drop box

		WebElement date = driver.findElement(By.id("day"));
		// create object of Select class
		Select select = new Select(date);
		select.selectByVisibleText("3");

		Thread.sleep(5000);
		driver.close();
	}
}
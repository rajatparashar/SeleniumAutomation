package qa.com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver","/home/rajat/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://html.com/input-type-file/");
		driver.manage().window().maximize();
		// DO NOT use sendkeys() with upload files button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement uploadButton = driver.findElement(By.xpath("//input[@name='fileupload']"));
		js.executeScript("arguments[0].scrollIntoView();", uploadButton);
		uploadButton.sendKeys("C://Users//My//Downloads//materialize.zip");
		Thread.sleep(5000);
		driver.close();
	}
}
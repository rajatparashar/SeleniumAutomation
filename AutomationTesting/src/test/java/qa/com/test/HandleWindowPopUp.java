package qa.com.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1. alerts - Javascript Pop Up -- Alert API (alert(), dismiss() methods are
		 * used) 2. File Upload Pop Up -- Browse Button (type='file' and sendKeys()
		 * method is used) 3. Browser Window Pop Up -- Advertisement Pop
		 * Up(windowHandler API - getWindowHandles() method is used)
		 */

//		System.setProperty("webdriver.chrome.driver", "/home/rajat/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.popuptest.com/goodpopups.html");

		WebElement popUpLink = driver.findElement(By.xpath("//a[@class='black']"));
		popUpLink.click(); // click on popup link

		Thread.sleep(2000);

		Set<String> handler = driver.getWindowHandles(); // store all the windows

		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent window id: " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("Child window id: " + childWindowId);
		// switch to child window

		driver.switchTo().window(childWindowId);

		Thread.sleep(2000);

		System.out.println("Child window popup title " + driver.getTitle());

		driver.close();// close popup window
		driver.switchTo().window(parentWindowId);

		Thread.sleep(2000);

		System.out.println("Parent window title " + driver.getTitle());
	}
}
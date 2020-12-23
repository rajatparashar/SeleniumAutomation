package qa.com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "/home/rajat/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com/");
		// get the total count of links on the page
		// get the text of each link on the page

		// all links are represented by <a> tag
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		// get size of linkList
		System.out.println(linkList.size());

		// get text of links
		for (int i = 0; i < linkList.size(); i++) {
			System.out.println(linkList.get(i).getText());
		}
		driver.close();
	}
}
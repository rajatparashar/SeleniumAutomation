package qa.com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver","/home/rajat/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"))).build().perform();
		Thread.sleep(2000);
		WebElement travelAgentLoginLink = driver.findElement(By.linkText("Travel Agent Login"));
		travelAgentLoginLink.click();
		driver.close();
	}
}
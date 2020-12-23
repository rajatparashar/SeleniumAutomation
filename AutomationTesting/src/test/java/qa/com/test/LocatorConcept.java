package qa.com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) throws IOException, InterruptedException {
//		System.setProperty("webdriver.chrome.driver","/home/rajat/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		driver.manage().window().maximize();

		// 1. xpath

		/*
		 * WebElement firstName =
		 * driver.findElement(By.xpath("//input[@id='firstname']"));
		 * firstName.sendKeys("John"); WebElement lastName =
		 * driver.findElement(By.xpath("//input[@id='lastname']"));
		 * lastName.sendKeys("Doe"); WebElement email =
		 * driver.findElement(By.xpath("//input[@id='email']"));
		 * email.sendKeys("johndoe@gmail.com");
		 */

		// 2. id

		/*
		 * WebElement firstName = driver.findElement(By.id("firstname"));
		 * firstName.sendKeys("John"); WebElement lastName =
		 * driver.findElement(By.id("lastname")); lastName.sendKeys("Doe"); WebElement
		 * email = driver.findElement(By.id("email"));
		 * email.sendKeys("johndoe@gmail.com");
		 */

		// 3. name

		/*
		 * WebElement firstName = driver.findElement(By.name("firstname"));
		 * firstName.sendKeys("John"); WebElement lastName =
		 * driver.findElement(By.name("lastname")); lastName.sendKeys("Doe"); WebElement
		 * email = driver.findElement(By.name("email"));
		 * email.sendKeys("johndoe@gmail.com");
		 */

		// 4. linktext(only for links)

		/*
		 * WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		 * signInLink.click();
		 */

		// 5. linktext(only for links) "Not recommended"

		/*
		 * WebElement notice =
		 * driver.findElement(By.partialLinkText("business account")); notice.click();
		 */

		// 6.CSSSelector

		/*
		 * WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
		 * firstName.sendKeys("John"); WebElement lastName =
		 * driver.findElement(By.cssSelector("#lastname")); lastName.sendKeys("Doe");
		 * WebElement email = driver.findElement(By.cssSelector("#email"));
		 * email.sendKeys("johndoe@gmail.com");
		 */

		// 7. className "Not recommended"

		WebElement needHelp = driver.findElement(By.className("faq-e chnls"));
		needHelp.click();
	}
}
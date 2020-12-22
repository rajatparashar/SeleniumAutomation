package qa.com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class TestClass {

//	@Test
//	public void googleSearchTest() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
//		driver.findElement(By.name("q")).sendKeys("ABC");		
//		Thread.sleep(2000);
//		driver.close();
//	}
//	
	
	
	

public static void main(String[] args) {

int input = 123456;
int remainder = 0, reverse = 0;

while(input > 0) {

remainder = input%10;
input = input/10;
reverse = reverse*10+remainder;

}

System.out.println(reverse);

}



	
}
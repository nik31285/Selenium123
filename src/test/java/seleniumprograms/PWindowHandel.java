package seleniumprograms;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PWindowHandel {
	WebDriver driver=null;
	@BeforeTest
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("file:///D:/Academic_21_22_sem_I/Java/JARS/file%20for%20practice/windowHandle/HandlingMultipleWindows.html");
	}
	@Test
	public void switchToAnotherWindow() {
		driver.findElement(By.xpath("//button[contains(text(),\"Try it\")]")).click();
		Set<String>WindowHandels=driver.getWindowHandles();
		for (String string : WindowHandels) {
			System.out.println(string);
		}
	}
}

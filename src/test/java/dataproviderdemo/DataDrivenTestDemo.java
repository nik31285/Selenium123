package dataproviderdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTestDemo {
	WebDriver driver=null;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\Academic_21_22_sem_I\\Java\\JARS\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Academic_21_22_sem_I/Java/JARS/file%20for%20practice/Create%20your%20first%20login%20page%20with%20HTML%20CSS%20and%20JavaScript/Create%20your%20first%20login%20page%20with%20HTML%20CSS%20and%20JavaScript/login-page.html");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="Invalid Data",dataProviderClass = Dataproviders.class)
	public void veryfyLoginPageWithInvalidData(String UserName, String Password) {
		driver.findElement(By.cssSelector("input#username-field")).sendKeys(UserName);
		driver.findElement(By.cssSelector("input#password-field")).sendKeys(Password);	
		driver.findElement(By.cssSelector("input#login-form-submit")).click();	
		String ErrMsg=driver.findElement(By.cssSelector("p#login-error-msg")).getText();
		String ExptMsg="Invalid username or password";
		Assert.assertEquals(ErrMsg,ExptMsg);
	
	}
	@AfterMethod
	public void clearText() {
		driver.findElement(By.cssSelector("input#username-field")).clear();
		driver.findElement(By.cssSelector("input#password-field")).clear();
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}

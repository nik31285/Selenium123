package com.crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel_CBT {
	WebDriver driver=null;
	@Parameters("browser")
	@BeforeTest
	public void launch(String browsername) {
		if(browsername.contains("Chrome")) {
			System.out.println("Opening "+browsername);
			System.setProperty("webdriver.chrome.driver","D:\\Academic_21_22_sem_I\\Java\\JARS\\Driver\\chromedriver.exe");
			 driver =new ChromeDriver();
			
		
		}
		else if(browsername.contains("Firefox")) {
			System.out.println("Opening"+browsername);
			System.setProperty("webdriver.firefox.driver","D:\\Academic_21_22_sem_I\\Java\\JARS\\Driver\\geckodriver.exe");
			System.out.println("Started Firefox");
			 driver=new FirefoxDriver();
		}
	}
	@Test
	public void m2() {
		driver.manage().window().maximize();
		driver.get("http://192.168.0.228:8090/httpclient.html");
	}

}

package com.ttt.TEST;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWeb {
	String url = "https://www.hankooktire.com/au/en/home.html";
	String pathChrome="D:\\5. FALL 2023\\Kiem Thu Nang Cao\\chromedriver-win64\\chromedriver.exe";
	public WebDriver driver;
	Random random;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", pathChrome);
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		

		driver.navigate().to(url);
		
		random = new Random();
		
	}
	
	@Test
	public void hanKookTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='util-search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("suv");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		String text =driver.findElement(By.xpath("//h2[@class='font_contents_title_1 dim txt-center en']")).getText();
		
		int randomNumber = random.nextInt(399);
		
		System.out.println("Ket qua la: "+randomNumber);
		if(text.contains(randomNumber+"")) {
			System.out.println("Chuc mung ban da trung giai doc dat");
		}else {
			System.out.println("Chuc ban may man lan sau");
		}
		
		
		
	}
	
	@AfterMethod
	public void closeBrownser() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("-------------------------");
		System.out.println("Hankook Hen gap lai!!!!");
		driver.close();
	}
	
	
}

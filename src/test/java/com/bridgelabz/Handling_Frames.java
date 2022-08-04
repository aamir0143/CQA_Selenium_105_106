package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handling_Frames {
	@Test
	public void frames_usingIndex() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Nodepad/HandlingFrames/Page2.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("t2")).sendKeys("Reza");
		driver.switchTo().frame(0);
		driver.findElement(By.id("t1")).sendKeys("Aamir");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	@Test
	public void frames_usingId () throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Nodepad/HandlingFrames/Page2.html");
		//using id attribute of the frame -string
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("Aamir");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Reza");
	}
	@Test
	public void frames_usingName () throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Nodepad/HandlingFrames/Page2.html");
		//using name attribute of the frame -string
		driver.switchTo().frame("n1");
		driver.findElement(By.id("t1")).sendKeys("Aamir");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Reza");
	}
	@Test
	public void frames_usingAddressFrame () throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Nodepad/HandlingFrames/Page2.html");
		//using address of the frame -webelement
		WebElement f = driver.findElement(By.className("c1"));
		driver.switchTo().frame(f);
		driver.findElement(By.id("t1")).sendKeys("Aamir");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Reza");
		//driver.close();
	}
	@Test
	public void frames_ThreeTextField() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Nodepad/HandlingFrames/Page2.html");
		// frames handling for three text field
		//using ID attribute
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("Aamir");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Khan");
		driver.findElement(By.id("t3")).sendKeys("Reza");

	}
}

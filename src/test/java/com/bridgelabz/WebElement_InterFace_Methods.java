package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElement_InterFace_Methods {
	@Test
	public void VerifyFB_GetLocationMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement unTB = driver.findElement(By.xpath("//input[@type='text']"));
		//get the y-coordinate of username field
		int username_Ycoordinate =unTB.getLocation().getY();
		System.out.println(username_Ycoordinate);
		WebElement pwdTB = driver.findElement(By.xpath("//input[@type='password']"));
		//get the y-coordinate of password field
		int password_Ycoordinate = pwdTB.getLocation().getY();
		System.out.println(password_Ycoordinate);
		//check whether the Y-coordinate of username and password field are same 
		if (username_Ycoordinate==password_Ycoordinate) {
			System.out.println("Both username and password fields are displayed in the same row");
		}
		else
		{
			System.out.println("username and password fields are Not aligned in the same row");
		}
	}
	@Test
	public void HeightAndWidth() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//Find the username field
		WebElement unTB = driver.findElement(By.xpath("//input[@type='text']"));
		//store the height of username
		int username_height = unTB.getSize().getHeight();
		//store the width of username
		int username_width = unTB.getSize().getWidth();
		System.out.println(username_height);
		System.out.println(username_width);
		//find the password field
		WebElement pwdTB = driver.findElement(By.xpath("//input[@type='password']"));
		//store the height of password
		int password_height = pwdTB.getSize().getHeight();
		//store the width of password
		int password_width = pwdTB.getSize().getWidth();
		System.out.println(password_height);
		System.out.println(password_height);
		//check the height and width of username and password fields are same
		if (username_height==password_height && username_width==password_width) {
			System.out.println("Username and password fields are aligned");
		}
		else
		{
			System.out.println("Username and password fields are Not aligned");
		}
	}
	@Test
	public void UsernameField_LessThan_MobNoField() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement unTB = driver.findElement(By.xpath("//input[@type='text']"));
		int username_width = unTB.getSize().getWidth();
		System.out.println(username_width);
		//Identify the mobile number text box
		WebElement mobileNumTB = driver.findElement(By.xpath("//input[contains(@aria-label,'Email address or phone number')]"));
		int mobNumwidth = mobileNumTB.getSize().getWidth();
		System.out.println(mobNumwidth);
		//compare the widthof both username and mobilenumber text box
		if (username_width==mobNumwidth) {
			System.out.println("Size of Both username and password fields are same" +username_width+" = "+mobNumwidth);
		}
		else
		{
			System.out.println("Size of Both username and password fields are Not same that is: " +username_width+"Not equals to"+mobNumwidth);
		}
	}
}

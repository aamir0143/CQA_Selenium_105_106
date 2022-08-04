package com.bridgelabz;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopUps {
	public static WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
	}
	@Test
	public void simpleAlertPopUp() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@Test
	public void conformationPopUp() throws InterruptedException {
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("confirmalertbox")).click();
		Thread.sleep(2000);
		Alert conformationAlert = driver.switchTo().alert();
		String alertText = conformationAlert.getText();
		System.out.println("the alert test is: "+alertText);
		conformationAlert.accept();
	}
	@Test
	public void promtPopUp() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);
		Alert promtAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		promtAlert.sendKeys("Aamir");
		Thread.sleep(2000);
		promtAlert.accept();
	}
	@Test
	public void fileUpload() throws InterruptedException {
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
        driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@multiple='']")).sendKeys("C:\\Users\\Md Aamir Reza\\Downloads\\AMIR REZAresume.pdf");
	}
	@Test
	public void auti_It() throws Exception {
		driver.get("https://www.sodapdf.com/txt-to-pdf/");
		 driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section[1]/div/div[2]/div[1]/div[2]/div/div[2]/label")).click();
		Runtime.getRuntime().exec("D:\\FileUploadScript.exe");
		Thread.sleep(5000);
		//driver.close();
	}
	//Child Browser PopUps-------
	@Test
	public void close_Parent_Window() throws InterruptedException {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentId = driver.getWindowHandle();
		System.out.println("parent id :" +parentId);
		driver.findElement(By.linkText("Register now")).click();
		Set<String> allWindow = driver.getWindowHandles();
		int count = allWindow.size();
		System.out.println("Number of window open by the selenium :" +count);
		for(String windowhandle : allWindow) {
			driver.switchTo().window(windowhandle);
			if(windowhandle.equals(parentId)) {
				driver.close();
			}
		}
	}
	@Test
	public void close_All_Child_Windows() {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String parentId = driver.getWindowHandle();
		//System.out.println("parent id :" +parentId);
		driver.findElement(By.linkText("Register now")).click();
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println("All window id's :" +allWindow);
		int count = allWindow.size();
		System.out.println("Number of window open by the selenium :" +count);
		for(String windowhandle : allWindow) {
			driver.switchTo().window(windowhandle);
			if(windowhandle.equals(parentId)) {
				driver.close();
			}
		}
	}
	@Test
	public void print_windowHandle() {
		//Program to print the window handle of a browser window ?
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		//get the window handle id of the browser
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}
	@Test
	public void countNumberOfBrowserWindows() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");

		//using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = driver.getWindowHandles();
		//using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
			//switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			//print the window handle id of each browser window
			System.out.println("Window handle id of page -->"+ title +" --> is : "+windowHandle);
			//close all the browsers one by one
			driver.close();
		}
	}
	@Test
	public void closeMainBrowserNotChildBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		//get the window handle id of the parent browser window
		String parentWindowhandleID = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
			//switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			/* compare the window id with the Parent browser window id, if both are equal, then
		only close the main browser window.*/
			if (windowHandle.equals(parentWindowhandleID)) {
				driver.close();
				System.out.println("Main Browser window with title -->"+ title +" --> is closed");
			}
		}
	}
	@Test
	public void closeAllChildBrowserWindowsExceptMainBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		//get the window handle id of the parent browser window
		String parentWindowhandleID = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();

		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
			//switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			/* compare the window id of all the browsers with the Parent browser window id, if it
		is not equal, then only close the browser windows.*/
			if (!windowHandle.equals(parentWindowhandleID)) {
				driver.close();
				System.out.println("Child Browser window with title -->"+ title +" --> is closed");
			}
		}
	}
	@Test
	public void closeSpecifiedBrowserWindow() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		//Set the expected title of the browser window which you want to close
		String expected_title = "Tech Mahindra";
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
			//switch to each browser window
			driver.switchTo().window(windowHandle);

			String actual_title = driver.getTitle();
			//Checks whether the actual title contains the specified expected title
			if (actual_title.contains(expected_title)) {
				driver.close();
				System.out.println("Specified Browser window with title -->"+ actual_title +" --> is closed");
			}
		}
	}
	@Test
	public void HandleTabs_using_getWindowHandles() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//enter actitime login url
		driver.get("https://demo.actitime.com/login.do");
		//get the window handle id of the parent browser window
		String parentwindowHandle = driver.getWindowHandle();
		//enter username
		driver.findElement(By.id("username")).sendKeys("admin");
		//enter password
		driver.findElement(By.name("pwd")).sendKeys("manager");
		//click on actiTIME INC link
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		//get the number of windows currently opened on the system

		Set<String> allwhs = driver.getWindowHandles();
		//switch to all the browser windows
		for (String wh : allwhs) {
		driver.switchTo().window(wh);
		}
		//get the title of the tab
		String childtitle = driver.getTitle();
		System.out.println("Title of the child tab is :"+ childtitle);
		//close the child tab
		driver.close();
		//switch back to the main browser window
		driver.switchTo().window(parentwindowHandle);
		//close the main browser window
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		//closing the parent window
		driver.close();
	}
}

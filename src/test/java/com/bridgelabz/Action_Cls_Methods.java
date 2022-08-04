package com.bridgelabz;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Action_Cls_Methods {
	public static WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
	}
	@Test
	public void test() throws AWTException, InterruptedException 
	{

		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement link=driver.findElement(By.linkText("actiTIME Inc."));
		//right click on facebook link
		Actions actions=new Actions(driver);
		actions.contextClick(link).perform();
		Thread.sleep(2000);
		//press w from the keyword for opening in a new windows 
		Robot r=new Robot();
		
		
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void moveToElement() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
	    
		 driver.manage().window().maximize();
		  Thread.sleep(2000);
		  WebElement element =driver.findElement(By.id("email"));
		  Actions actions=new Actions(driver);
		  actions.moveToElement(element).perform();
		  Thread.sleep(2000);
		  WebElement element1=driver.findElement(By.id("pass"));
		  element.click();
		  
		   
	}
	@Test
	public void dragDrop() throws InterruptedException
	{
		driver.get("https://jqueryui.com/droppable/");
		 driver.manage().window().maximize();
		  Thread.sleep(2000);
		  driver.switchTo().frame(0);
		  WebElement element=driver.findElement(By.xpath("//div[@id='draggable']"));
		  WebElement element1=driver.findElement(By.xpath("//div[@id='droppable']"));
		  Actions actions=new Actions(driver);
		  actions.dragAndDrop(element, element1).perform();
		  actions.clickAndHold(element1).release().perform();
		  actions.moveToElement(element1).release().perform();
		  Thread.sleep(2000);
		  driver.close();
	}
	@Test
	public void gmail_contextClickDemo_mailArchive() throws InterruptedException{
		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();
		// enter email id
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ahsankumar22@gmail.com");
		// click on Next button
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(3000);
		// enter password id
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("kumar0143");
		//click on Next button
		driver.findElement(By.xpath("//span[.='Next']")).click();
		//driver.findElement(By.xpath("//*[@id=\":3k\"]")).click();
		//Thread.sleep(10000);
		//Write xpath expression for the mail item based on a subject
		String xp = "//span[text()='Hi bro']";
		//get the address of the mail item which you want to archive
		WebElement mail = driver.findElement(By.xpath(xp));
		//print the subject of the mail
		System.out.println(mail.getText());
		//Creating an object of Actions class 
		Actions actions = new Actions(driver);
		//using Actions class object and contextClick() method, right click on the mail item
		actions.contextClick(mail).perform();
		Thread.sleep(6000);
		//click on Archive to archive the mail 
		driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();
	}
	@Test
	public void keys() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).perform();
		Thread.sleep(4000);
		actions.sendKeys("qspiders").perform();
		Thread.sleep(4000);
		actions.keyUp(Keys.SHIFT).perform();
		Thread.sleep(4000);
		actions.doubleClick(search).perform();
		Thread.sleep(4000);
		actions.keyDown(Keys.CONTROL).sendKeys("x").perform();
		Thread.sleep(4000);
		actions.keyUp(Keys.CONTROL).perform();
		Thread.sleep(4000);
		actions.keyDown(Keys.CONTROL).sendKeys("v").build();
		Thread.sleep(4000);
		actions.keyUp(Keys.CONTROL).perform();
		
	}

}

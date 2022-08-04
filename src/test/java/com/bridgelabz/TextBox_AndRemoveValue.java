package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class TextBox_AndRemoveValue {
	@Test
	public void AddValueInTextBox_AndRemove() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//entering text into the focussed element
		driver.switchTo().activeElement().sendKeys("admin");
	}
	@Test
	public void RemoveElementFromTextBox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("aamirreza156@gmail.com");
		Thread.sleep(2000);
		String value = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		System.out.println("Value present inside the text box is: "+value);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("againEnteredAamir");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		//this line will actually delete the value if there is no space in the text entered
		//if there is a space between two words in the username field,we have to use the below lines of code 
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL+"a");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.DELETE);
		Thread.sleep(2000);
	}
	@Test
	public void DeleteWithoutUsingClear() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ajit");
		Thread.sleep(2000);
		String value = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		System.out.println("Value present inside the text box is: "+value);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("againEnteredAjit");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		Thread.sleep(2000);
	}
	@Test
	public void ToolTip() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement Checkbox = driver.findElement(By.xpath("//input[@type='text']"));
		//get the tooltip text using getAttribute()method and store in avariable
		String tooltipText = Checkbox.getAttribute("title");
		System.out.println(tooltipText);
	}
	@Test
	public void isSelected() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement KeepMeLogIN_Checkbox = driver.findElement(By.xpath("//label[contains(text(),'Person With Disability Concession')]"));
	    KeepMeLogIN_Checkbox.click();
		if (KeepMeLogIN_Checkbox.isSelected()) {
			System.out.println("Checkbox is selected");
			}else{
			System.out.println("Checkbox is NOT selected");
			}
	}
	@Test
	public void isEnable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement UN = driver.findElement(By.xpath("//input[@type='text']"));
		if (UN.isEnabled()) {
			System.out.println("Username text box is enabled");
		}
		else
		{
			System.out.println("Username text box is disabled");
		}
		driver.close();
	}
	@Test
	public void getText() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String tagName = driver.findElement(By.xpath("//input[@type='text']")).getTagName();
		if (tagName.equals("a")) {
			System.out.println("View LIcence is a link");
		}
		else
		{
			System.out.println("View LIcence is NOT a link");
		}
		driver.close();
	}
	@Test
	public void getAttribute() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String elementType = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("aamirreza156@gmail.com");
		System.out.println(elementType);
		if (elementType.equalsIgnoreCase("elementType")) {
			System.out.println("it is a checkbox");
		}else{
			System.out.println("it is NOT a checkbox");
		}}
	@Test
	public void getCssValue() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Md Aamir Reza\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//click on login button
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		//find the error message element
		WebElement errMsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		//get the text of the error message
		String errText = errMsg.getText();
		//print the error message
		System.out.println("error message is: "+errText);
		//get the value of color and store in a variable
		String c = errMsg.getCssValue("color");
		//convert the color from string type to hexa form
		String ColorasHex = Color.fromString(c).asHex();
		System.out.println("hexadecimal formate : "+ColorasHex);
		if (ColorasHex.equals("#ce0100")) {
			System.out.println("Error message is in red color");
		}
		else
		{
			System.out.println("Error message is NOT in red color");
		}
		//get the size of the font of error message
		String fontSize = errMsg.getCssValue("font-size");
		//get the weight of the font of error message
		String fontWeight = errMsg.getCssValue("font-weight");
		System.out.println("Size of the font is : "+fontSize);
		System.out.println("Weight of the font is : "+fontWeight);
		driver.close();
	}
}

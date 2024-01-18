package selenium_demo.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesExample {
	static WebDriver d;

	public static void main(String[] args) throws Exception {
		d = new FirefoxDriver();
		//frame with index
		//enterData(0);
		//frame with id
		//enterData("singleframe");
		//frame with name 
		//enterData("SingleFrame");
		//frame with webelement
		enterData("//iframe[@name='SingleFrame']");
		
	}
	public static void enterData(Object ...args) throws Exception
	{
		
		//d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(5000);
		d.switchTo().frame((int) args[0]);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("TestingFrames");
	}
	
	public static void enterData(int args) throws Exception
	{
		//d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(5000);
		d.switchTo().frame(args);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("TestingFrames");
	}
	
	/*public static void enterData(String args) throws Exception
	{
		//d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(5000);
		d.switchTo().frame(args);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("TestingFrames");
	}*/
	
	public static void enterData(String xpathofFrame) throws Exception
	{
		//d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(5000);
		WebElement frame = d.findElement(By.xpath(xpathofFrame));
		d.switchTo().frame(frame);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("TestingFrames");
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.findElement(By.xpath("//ul//li//a[text()='Home']")).click();
		
	}
}

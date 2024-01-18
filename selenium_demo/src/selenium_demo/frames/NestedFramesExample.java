package selenium_demo.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NestedFramesExample {
	static WebDriver d;

	public static void main(String[] args) throws Exception {
		d = new FirefoxDriver();
		enterData("//iframe[@src='MultipleFrames.html']", "//div[@class='iframe-container']//iframe[@src='SingleFrame.html']");
	}
	
	public static void enterData(String frame1, String frame2) throws Exception
	{
		//d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(5000);
		d.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		Thread.sleep(2000);
		WebElement frm1 = d.findElement(By.xpath(frame1));
		//frame1
		d.switchTo().frame(frm1);
		Thread.sleep(3000);
		WebElement frm2 = d.findElement(By.xpath(frame2));
		//frame2
		d.switchTo().frame(frm2);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("TestingFrames");
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.findElement(By.xpath("//ul//li//a[text()='Home']")).click();
		
	}
}

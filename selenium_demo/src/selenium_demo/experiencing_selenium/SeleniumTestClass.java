package selenium_demo.experiencing_selenium;

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestClass {

	public static void main(String[] args) throws Exception {
		String filepath = System.getProperty("user.dir")+"/MyDataFiles/Source.txt";
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		System.out.println(d.getWindowHandle());
		d.navigate().refresh();
		d.get("https://demo.automationtesting.in/Register.html");
		System.out.println(d.getTitle());
		System.out.println(d.getCurrentUrl());
		String str = d.getPageSource();
		FileWriter fw = new FileWriter(filepath);
		fw.write(str);
		Thread.sleep(5000);
		d.navigate().refresh();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[text()='Home']")).click();
		Thread.sleep(3000);
		d.navigate().back();
		Thread.sleep(3000);
		d.navigate().forward();
		d.close();
		
		
		
	}

}

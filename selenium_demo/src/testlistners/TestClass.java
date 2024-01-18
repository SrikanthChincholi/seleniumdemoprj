package testlistners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ TestListenerClass.class })
public class TestClass {

	WebDriver d;

	@BeforeMethod
	public void bmeth() {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in");
	}

	@Test
	public void getTitle() {
		System.out.println(d.getTitle());
	}

	@Test
	public void getUrl() {
		System.out.println(d.getCurrentUrl());
	}

	@AfterMethod
	public void ameth() {
		d.quit();

	}

}

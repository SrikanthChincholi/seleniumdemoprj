package testngprgms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertions2 {
	WebDriver d;
	
	@BeforeMethod
	public void bmeth() {

		d = new ChromeDriver();
		d.get("https://demo.automationtesting.in/Register.html");
	}

	@Test
	public void test1() {
		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		Assert.assertEquals("Register123", apptitle);
		System.out.println("Title not matched");
	}
	
	@Test
	public void test2() {
		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		Assert.assertEquals("Register3", apptitle);
		System.out.println("Title not matched");

	}

	@Test
	public void test3() {

		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		Assert.assertEquals("Register", apptitle);
		System.out.println("Title matched");
	}
	
	
	@AfterMethod
	public void ameth() {
		d.quit();
	}
}

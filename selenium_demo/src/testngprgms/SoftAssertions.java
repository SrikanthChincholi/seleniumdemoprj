package testngprgms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	WebDriver d;
	SoftAssert sassert;
	
	@BeforeClass
	public void bclass(){
		sassert = new SoftAssert();
	}

	@BeforeMethod
	public void bmeth() {

		d = new ChromeDriver();
		d.get("https://demo.automationtesting.in/Register.html");
		
	}

	@Test
	public void test1() {
		
		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		sassert.assertEquals("Register123", apptitle);
		System.out.println("Title not matched");
		//sassert.assertAll();
	}

	@Test
	public void test2() {
		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		sassert.assertEquals("Register3", apptitle);
		System.out.println("Title not matched");
		//sassert.assertAll();
	}

	@Test
	public void test3() {

		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		sassert.assertEquals("Register", apptitle);
		System.out.println("Title matched");
		
	}

	
	@AfterMethod
	public void ameth() {
		d.quit();
	}
	
	@AfterClass
	public void aclass()
	{
		sassert.assertAll();
	}
}

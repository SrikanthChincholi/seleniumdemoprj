package testngprgms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestngAnnotations3 {
	WebDriver d;

	@BeforeSuite
	public void bsuite() {

		System.out.println("This is Before Suite");
	}

	@BeforeTest
	public void btest() {
		System.out.println("This is Before Test");
	}

	@BeforeTest
	public void btest1() {
		System.out.println("This is Before Test1");
	}

	@BeforeClass
	public void bclass() {
		System.out.println("This is Before Class");
	}

	@BeforeMethod
	public void bmeth() {
		System.out.println("This is Before Method");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in");
	}

	@Test
	public void test3() {
		System.out.println("This is actaul test3");
		System.out.println(d.getPageSource());
	}

	@AfterSuite
	public void asuite() {
		System.out.println("This is After Suite");
	}

	@AfterTest
	public void atest() {
		System.out.println("This is After Test");
	}

	@AfterClass
	public void aclass() {
		System.out.println("This is After Class");
	}

	@AfterMethod
	public void ameth() {
		System.out.println("This is After Method");
		d.quit();
	}

}

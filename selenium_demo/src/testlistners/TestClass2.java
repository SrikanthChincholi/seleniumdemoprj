package testlistners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListenerClass.class })
public class TestClass2 {

	WebDriver d;

	@BeforeMethod
	public void bmeth() {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in");
	}

	@Test
	public void validateTitle() {
		Assert.assertEquals(d.getTitle(), "Amazon", "Not Matched !!");

	}

	@Test()
	public void testtobeSkipped() {
		throw new SkipException("This test is skipped !!");

	}

	@AfterMethod
	public void ameth() {
		d.quit();

	}

}

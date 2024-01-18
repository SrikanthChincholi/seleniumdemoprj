package testngprgms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	public void test() {
		WebDriver d = new ChromeDriver();
		d.get("https://demo.automationtesting.in/Register.html");
		String apptitle = d.getTitle();
		System.out.println("Title from application :" + apptitle);
		Assert.assertEquals("Register", apptitle);
		System.out.println("Title matched");
		d.quit();

	}
}

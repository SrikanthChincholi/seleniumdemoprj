package testngprgms;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupingTests2 {

	WebDriver d;

	@Test(priority = 1, groups = { "wind10" })
	public void launchapplication() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//throw new Exception("test failed");
	}

	@Test(priority = 2, groups = { "wind11" }, dependsOnMethods = "launchapplication")
	public void login() throws Exception {
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123", Keys.RETURN);
		//throw new Exception("test failed");
	}

	@Test(priority = 3, groups = { "wind12" },dependsOnMethods ="login")
	public void checkLogin() {
		WebElement ele = d.findElement(By.xpath("//span//h6"));
		if (ele.isDisplayed()) {
			System.out.println("Login success !!");
		}

	}

	@Test(priority = 4, groups = { "wind14" })
	public void clickonPIM() {
		d.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@Test(priority = 4, groups = { "wind15" })
	public void closebrowser() throws Exception {
		Thread.sleep(3000);
		d.quit();
	}

}

package testngprgms;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupingTests {

	WebDriver d;

	@Test(priority = 1, groups = { "smoke" })
	public void launchapplication() {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 2, groups = { "smoke" })
	public void login() {
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123", Keys.RETURN);

	}

//	@Test(priority = 3, groups = { "Regression" })
	public void checkLogin() {
		WebElement ele = d.findElement(By.xpath("//span//h6"));
		if (ele.isDisplayed()) {
			System.out.println("Login success !!");
		}

	}

	@Test(priority = 4, groups = { "Regression" }, dependsOnMethods = "checkLogin",ignoreMissingDependencies = true)
	public void clickonPIM() {
		d.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@Test(priority = 4, groups = { "Regression" })
	public void closebrowser() throws Exception {
		Thread.sleep(3000);
		d.quit();
	}

}

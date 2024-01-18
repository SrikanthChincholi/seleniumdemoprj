package dataproviderpack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturnTypes {

	protected ThreadLocal<WebDriver> d = new ThreadLocal<>();

	@Test(dataProvider = "logintestdata1")
	public void loginTestwithData1(String username, String password,String dashboard) {
		logintest(username, password,dashboard);
		
	}
	
	//@Test(dataProvider = "logintestdata2")
	public void loginTestwithData2(String s) {
		logintest(s);
		
	}

	private void logintest(String username, String password,String dashboard) {
		try {
			d.set(new ChromeDriver());
			d.get().manage().window().maximize();
			d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.get().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			d.get().findElement(By.xpath("//input[@name='password']")).sendKeys(password, Keys.RETURN);
			List<WebElement> dashboardtxt = d.get().findElements(By.xpath("//h6[text()='Dashboard']"));
			Assert.assertEquals(dashboardtxt.get(0).getText(), dashboard, "Login Success !!");

		} finally {
			d.get().quit();
		}
	}

	private void logintest(String s) {
		try {
			d.set(new ChromeDriver());
			d.get().manage().window().maximize();
			d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.get().findElement(By.xpath("//input[@name='username']")).sendKeys(s);
			d.get().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123", Keys.RETURN);
			List<WebElement> dashboard = d.get().findElements(By.xpath("//h6[text()='Dashboard']"));
			Assert.assertEquals(dashboard.get(0).getText(), "Dashboard", "Login Success !!");

		} finally {
			d.get().quit();
		}
	}

	@DataProvider(name = "logintestdata1")
	public Object[][] logindata1() {
		Object[][] data = new Object[][] { { "admin", "admin123","Dashboard" }, { "admin1", "admin123","Dashboard" }, { "admin2", "admin123","Dashboard" },
				{ "admin", "admin123","Dashboard" }, { "admin", "admin123","Dashboard" } };
		return data;
	}

	@DataProvider(name = "logintestdata2")
	public Object[] logindata2() {
		Object[] data = new Object[] { "admin", "admin" };
		return data;

	}
	
	
}

package dataproviderpack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	protected ThreadLocal<WebDriver> d = new ThreadLocal<>();

	@Test(dataProvider = "logintestdata", dataProviderClass = DataProviderContainer.class)
	public void loginTestwithData(String username, String password) {
		logintest(username, password);
	}

	private void logintest(String username, String password) {
		try {
			d.set(new ChromeDriver());
			d.get().manage().window().maximize();
			d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.get().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			d.get().findElement(By.xpath("//input[@name='password']")).sendKeys(password, Keys.RETURN);
			List<WebElement> dashboard = d.get().findElements(By.xpath("//h6[text()='Dashboard']"));
			Assert.assertEquals(dashboard.get(0).getText(), "Dashboard", "Login Success !!");

		} finally {
			d.get().quit();
		}

	}

}

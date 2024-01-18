package paralleltest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTest {

	ThreadLocal<WebDriver> d = new ThreadLocal<WebDriver>();

	@Test()
	public void launchapplication() {
		d.set(new ChromeDriver());
		d.get().manage().window().maximize();
		d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.get().findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		d.get().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123", Keys.RETURN);
		d.get().quit();

	}

}

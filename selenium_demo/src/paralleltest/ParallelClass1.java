package paralleltest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelClass1 {

	ThreadLocal<WebDriver> d = new ThreadLocal<>();

	@Test()
	public void launchapplication() throws Exception {
		d.set(new ChromeDriver());
		Dimension dim = new Dimension(500, 500);
		d.get().manage().window().setSize(dim);
		d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(d.get().getTitle());
		Thread.sleep(3000);
		d.get().quit();
	}

	
}

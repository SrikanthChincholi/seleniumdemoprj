package basepacck;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected ThreadLocal<WebDriver> d = new ThreadLocal<>();

	@Parameters("browser")
	@BeforeMethod
	public void browserSetup(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			d.set(new ChromeDriver());
			d.get().manage().window().maximize();
			d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		} else if (browser.equalsIgnoreCase("Firefox")) {
			d.set(new FirefoxDriver());
			d.get().manage().window().maximize();
			d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		} else if (browser.equalsIgnoreCase("Edge")) {
			d.set(new EdgeDriver());
			d.get().manage().window().maximize();
			d.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
	}

	@AfterMethod
	public void tearDown() {
		d.get().quit();
	}

}

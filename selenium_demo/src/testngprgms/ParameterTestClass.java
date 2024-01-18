package testngprgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestClass {
	WebDriver d = null;

	@Parameters({ "url", "uname", "pswd" })
	@Test
	public void login(String url, String uname, String pswd) throws Exception {
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get(url);
		String title = d.getTitle();
		System.out.println(title);
		d.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		d.findElement(By.xpath("//input[@name='password']")).sendKeys(pswd, Keys.RETURN);
		Thread.sleep(5000);
		d.quit();
	}

	@Parameters("browser")
	@Test
	public void browerSetup(@Optional("Chrome")String  browsername) throws Exception {
		if (browsername.equalsIgnoreCase("Chrome")) {
			d = new ChromeDriver();
			System.out.println("Chrome browser launched!!! ");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		} else if (browsername.equalsIgnoreCase("Firefox")) {
			d = new FirefoxDriver();
			System.out.println("Firefox browser launched!!! ");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else if (browsername.equalsIgnoreCase("Edge")) {
			d = new EdgeDriver();
			System.out.println("Edge browser launched!!! ");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

	}

}

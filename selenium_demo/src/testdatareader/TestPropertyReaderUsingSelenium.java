package testdatareader;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPropertyReaderUsingSelenium {

	static WebDriver d;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.manage().window().maximize();
		WebElement uname = d.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys(PropertiesFileReader.getValue("uname"));
		WebElement pswd = d.findElement(By.xpath("//input[@name='password']"));
		pswd.sendKeys(PropertiesFileReader.getValue("password"));
		d.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement dashboard = waitforElement(By.xpath("//span/h6[text()='Dashboard']"));
		if (dashboard.isDisplayed()) {
			System.out.println("Login success");
			d.quit();
		}

	}

	public static WebElement waitforElement(By by) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}

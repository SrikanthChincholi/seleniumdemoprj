package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeoutExample {
	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		d.get("https://demo.automationtesting.in/Register.html");
		ele = d.findElement(By.xpath("//input[@placeholder='First Name']"));
		ele.sendKeys("Srikanth");
		ele = d.findElement(By.xpath("//input[@placeholder='Last Name']"));
		ele.sendKeys("Chincholi");
	}

}

package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitExample {
	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new FirefoxDriver();
		d.manage().window().setSize(new Dimension(1000, 1000));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://demo.automationtesting.in/ProgressBar.html");
		ele = d.findElement(By.xpath("//button[text()=' Download']"));
		ele.click();
		//Thread.sleep();
		ele1 = d.findElement(By.xpath("//div[text()='100']"));
		System.out.println(ele1.getText());

	}

}

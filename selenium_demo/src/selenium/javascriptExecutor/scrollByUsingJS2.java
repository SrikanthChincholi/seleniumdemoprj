package selenium.javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollByUsingJS2 {
	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.nasa.gov/");
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) d);
		js.executeScript("window.scrollBy(0,1000)");
		//ele = d.findElement(By.xpath("(//span[text()='Science'])[2]"));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-1000)");
	}
}

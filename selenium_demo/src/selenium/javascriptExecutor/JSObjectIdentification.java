package selenium.javascriptExecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSObjectIdentification {
	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		amazon();
		orangehrm();
	}
	
	public static void amazon() throws Exception
	{
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) d);
		WebElement element = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox')");
		element.sendKeys("Curtains");
		element.submit();
		Thread.sleep(5000);
		d.quit();
	}
	
	public static void orangehrm() throws Exception
	{
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) d);
		List<WebElement> element = (List<WebElement>) js.executeScript("return document.getElementsByName('username')");
		element.get(0).sendKeys("admin");
		List<WebElement> alltags = (List<WebElement>) js.executeScript("return document.getElementsByTagName('a')");
		for (WebElement elemts : alltags) {
			System.out.println(elemts.getAttribute("href"));
		}

		Thread.sleep(5000);
		d.quit();
	}
	
	

}

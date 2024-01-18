package selenium.javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighElement {
	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//input[@placeholder ='First Name']"));
		highlightElement(ele);
		ele = d.findElement(By.xpath("//button[@type='submit']"));
		scrollIntoViewElement(ele);
		Thread.sleep(2000);
		clickElement(ele);

	}

	public static void highlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style','background : blue ; border : 2px solid red;')", ele);

	}
	
	public static void scrollIntoViewElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView()", ele);

	}

	public static void clickElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].click()", ele);

	}
}

package selenium.javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollIntoViewUsingJS {
	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.nasa.gov/");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("(//span[text()='Science'])[2]"));
		Thread.sleep(2000);
		scrollIntoViewElement(ele);
		Thread.sleep(2000);
		highlightElement(ele);
		Thread.sleep(2000);
		clickElement(ele);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) d;
		WebElement search = (WebElement) js.executeScript("return document.getElementById('search-field-en-small')");
		search.sendKeys("Space");
		search.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		d.quit();

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



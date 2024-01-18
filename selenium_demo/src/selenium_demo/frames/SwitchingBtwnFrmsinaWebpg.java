package selenium_demo.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingBtwnFrmsinaWebpg {

	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://docs.oracle.com/javase/7/docs/api/index.html?java/awt/package-summary.html");
		Thread.sleep(2000);
		d.switchTo().frame("packageListFrame");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//a[text()='java.applet']"));
		highlight(ele);
		ele.click();
		Thread.sleep(3000);
		d.switchTo().defaultContent();
		Thread.sleep(2000);
		d.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//a[text()='Applet']"));
		highlight(ele);
		ele.click();
		d.switchTo().defaultContent();
		Thread.sleep(2000);
		d.switchTo().frame("classFrame");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//a[text()='JApplet']"));
		highlight(ele);
		ele.click();

	}

	public static void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 3px solid red;')", ele);
	}

}

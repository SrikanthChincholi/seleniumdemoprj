package actionsClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample3 {

	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(2000);
		// d.findElement(By.xpath("//input[@placeholder='First
		// Name']")).sendKeys("Srikanth");
		// Thread.sleep(3000);
		Actions act = new Actions(d);
		ele = d.findElement(By.xpath("//span[text()='right click me']"));
		Thread.sleep(3000);
		act.contextClick(ele).build().perform();
		List<WebElement> alloptions = d
				.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span"));
		for (WebElement ele : alloptions) {
			if ("Paste".equalsIgnoreCase(ele.getText())) {
				act.moveToElement(ele).click().build().perform();
				Alert alt = d.switchTo().alert();
				Thread.sleep(2000);
				System.out.println(alt.getText());
				Thread.sleep(2000);
				alt.accept();
			}
		}

		/*
		 * act.pause(Duration.ofSeconds(2)).perform(); act.click().perform();
		 * act.sendKeys("Srikanth").perform();
		 * d.findElement(By.xpath("//input[@id='alertbtn']")).click(); Alert alt =
		 * d.switchTo().alert(); Thread.sleep(2000); System.out.println(alt.getText());
		 * Thread.sleep(2000); alt.accept();
		 */

	}

	public static void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 3px solid red;')", ele);
	}

}

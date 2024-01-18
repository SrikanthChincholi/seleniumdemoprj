package actionsClass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample2 {

	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.letskodeit.com/practice");
		Thread.sleep(2000);
		// d.findElement(By.xpath("//input[@placeholder='First
		// Name']")).sendKeys("Srikanth");
		// Thread.sleep(3000);
		Actions act = new Actions(d);
		ele = d.findElement(By.xpath("//input[@name='enter-name']"));
		Thread.sleep(3000);
		act.moveToElement(ele).perform();
		act.pause(Duration.ofSeconds(2)).perform();
		act.click().perform();
		act.sendKeys("Srikanth").perform();
		d.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert alt = d.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alt.getText());
		Thread.sleep(2000);
		alt.accept();

	}

	public static void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 3px solid red;')", ele);
	}

}

package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample {

	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.letskodeit.com/practice");
		Thread.sleep(2000);
		//d.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Srikanth");
		//Thread.sleep(3000);
		Actions act = new Actions(d);
		ele = d.findElement(By.xpath("//button[@id='mousehover']"));
		Thread.sleep(3000);
		act.moveToElement(ele)
		.pause(Duration.ofSeconds(2))
		.click(d.findElement(By.xpath("//a[text()='Reload']")))
		.build().perform();
		

	}

	public static void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 3px solid red;')", ele);
	}

}

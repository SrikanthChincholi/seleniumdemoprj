package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClassScrollBy {

	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/slider/#colorpicker");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("(//a[text()='Learning Center'])[2]"));
		Actions act = new Actions(d);
		act.scrollByAmount(0,2500).perform();
		Thread.sleep(2000);
		act.scrollByAmount(0,-1000).perform();
		//Actions act = new Actions(d);
		
	}

}

package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassClickAndHold {

	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/slider/#colorpicker");
		Thread.sleep(2000);
		d.switchTo().frame(0);
		ele = d.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
		ele1 = d.findElement(By.xpath("//div[contains(@class,'ui-slider-range')]"));
		Actions act = new Actions(d);
		act.clickAndHold(ele).moveToElement(ele1, -25, 0).release().build().perform();

	}

}

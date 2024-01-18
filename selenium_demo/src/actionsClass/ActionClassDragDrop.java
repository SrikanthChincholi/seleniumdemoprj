package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDragDrop {

	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {
		clickAndHoldEle();
	}

	public static void dragDropEle() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		d.switchTo().frame(0);
		ele = d.findElement(By.xpath("//div[@id='draggable']"));
		ele1 = d.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(d);
		act.dragAndDrop(ele, ele1).perform();
		confrmmsg = d.findElement(By.xpath("//div[@id='droppable']/p"));
		System.out.println(confrmmsg.getText());
	}

	public static void clickAndHoldEle() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		d.switchTo().frame(0);
		ele = d.findElement(By.xpath("//div[@id='draggable']"));
		ele1 = d.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(d);
		act.moveToElement(ele).clickAndHold().moveToElement(ele1).pause(Duration.ofSeconds(2)).release().build()
				.perform();
		//act.dragAndDrop(ele, ele1).perform();
		confrmmsg = d.findElement(By.xpath("//div[@id='droppable']/p"));
		System.out.println(confrmmsg.getText());
	}

}

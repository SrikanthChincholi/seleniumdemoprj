package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDragDropBy {

	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/draggable/");
		Thread.sleep(2000);
		d.switchTo().frame(0);
		ele = d.findElement(By.xpath("//div[@id='draggable']"));
		// ele1 = d.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(d);
		act.dragAndDropBy(ele, 100, 0).perform();
		Thread.sleep(3000);
		act.dragAndDropBy(ele, -50, 0).perform();

	}

}

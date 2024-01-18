package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPasteData {
	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//input[@placeholder='First Name']"));
		ele.sendKeys("Srikanth");
		ele.sendKeys(Keys.CONTROL, "a");
		String copy = Keys.chord(Keys.CONTROL + "c");
		ele.sendKeys(copy);
		ele.sendKeys(Keys.TAB);
		Actions act = new Actions(d);
		pasteData(act);
		Thread.sleep(3000);
		act.keyDown(Keys.TAB).perform();
		act.keyUp(Keys.TAB).perform();
		Thread.sleep(3000);
		pasteData(act);
		
	}
	
	public static void pasteData(Actions act)
	{
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	}
}

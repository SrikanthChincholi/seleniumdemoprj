package selenium_demo.experiencing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassExample {

	static WebDriver d = null;

	public static void main(String[] args) throws Exception {
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		WebElement selectcars = d.findElement(By.xpath("//select[@ng-model='Skill']"));
		highlightEle(selectcars);
		Select selectcar = new Select(selectcars);
		selectcar.selectByValue("CSS");
		Thread.sleep(3000);
		selectcar.selectByVisibleText("HTML");
		Thread.sleep(3000);
		selectcar.selectByVisibleText("PHP");
		Thread.sleep(3000);
		d.quit();
	}

	public static void highlightEle(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 2px solid red;')", ele);

	}
}

package handlingalerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertExample3 {

	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Loader.html");
		Thread.sleep(3000);
		ele = d.findElement(By.xpath("//button[text()='Run']"));
		highlight(ele);
		ele.click();
		Thread.sleep(2000);
		ele = waitForElement(By.xpath("//div[@class='modal-body']/p"), 180);
		highlight(ele);
		System.out.println(ele.getText());
		d.quit();

	}

	public static WebElement waitForElement(By by, int duration) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 3px solid red;')", ele);
	}
}
package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitExample {
	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;

	public static void main(String[] args) throws Exception {

		d = new FirefoxDriver();
		d.manage().window().setSize(new Dimension(1000, 1000));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://demo.automationtesting.in/Loader.html");
		ele = d.findElement(By.xpath("//button[text()='Run']"));
		ele.click();
		// Thread.sleep();
		try {
			boolean isDisappeared = waitForInvisibity(By.xpath("//div//h1[text()='Please wait...']"));
			if (isDisappeared) {
				Thread.sleep(1000);
				WebElement ele1 = d.findElement(By.xpath("//div[@class='modal-body']/p"));
				System.out.println(ele1.getText());
			}
		} catch (Exception e) {
			throw new Exception("Element still visible on the screen....");
		}
	}

	public static WebElement waitForVisibity(By by) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static WebElement waitForVisibity(By by, WebDriver d) {
		Wait<WebDriver> wait = getFluent(by);
		WebElement webElewait = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElewait;
	}

	public static boolean waitForInvisibity(By by) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(3));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	private static Wait<WebDriver> getFluent(By by) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(d).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		return fwait;
	}

}

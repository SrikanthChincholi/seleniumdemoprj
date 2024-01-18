package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitExample2 {
	static WebDriver d;
	static WebElement ele, ele1, confrmmsg;
	static String banks[] = { "Allahabad Bank", "Andhra Bank", "Axis Bank" };

	public static void main(String[] args) throws Exception {

		d = new FirefoxDriver();
		d.manage().window().setSize(new Dimension(1000, 1000));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://indialends.com/IFSC/axis-bank");
		ele = d.findElement(By.xpath("//select[@id='ddlBank']"));
		Select select = new Select(ele);
		for (String bank : banks) {

			ele = d.findElement(By.xpath("//select[@id='ddlBank']"));
			select = new Select(ele);
			select.selectByVisibleText(bank);
			Thread.sleep(1000);

		}
	}

	public static WebElement waitForVisibity(By by) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static WebElement waitForVisibity(By by, WebDriver d) {
		Wait<WebDriver> wait = getFluent();
		WebElement webElewait = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElewait;
	}

	public static boolean waitForInvisibity(By by) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(3));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	private static Wait<WebDriver> getFluent() {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(d).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return fwait;
	}

}

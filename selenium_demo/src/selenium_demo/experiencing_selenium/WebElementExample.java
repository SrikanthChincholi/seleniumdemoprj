package selenium_demo.experiencing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExample {

	static WebDriver d = null;

	public static void main(String[] args) throws Exception {

		identifyElewithID();
		identifyElewithName();
		identifyElewithClassname();
		identifyElewithLinkText();
		identifyElewithPartialLinkText();

	}

	public static void identifyElewithID() throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		System.out.println(d.getWindowHandle());
		d.navigate().refresh();
		d.get("https://www.amazon.in/");
		WebElement ele = d.findElement(By.id("twotabsearchtextbox"));
		ele.sendKeys("TV");
		ele.submit();
		tearDown();

	}

	public static void identifyElewithName() throws Exception {
		loadapplication();
		WebElement ele = d.findElement(By.name("username"));
		ele.sendKeys("admin");
		tearDown();

	}

	public static void identifyElewithClassname() throws Exception {
		loadapplication();
		WebElement pswd = d.findElement(By.className("oxd-label"));
		System.out.println(pswd.getText());
		tearDown();
	}

	public static void identifyElewithLinkText() throws Exception {
		loadapplication();
		WebElement ltext = d.findElement(By.linkText("OrangeHRM, Inc"));
		ltext.click();
		tearDown();
	}

	public static void identifyElewithPartialLinkText() throws Exception {
		{
			loadapplication();
			Thread.sleep(3000);
			WebElement pltext = d.findElement(By.partialLinkText("OrangeHRM"));
			pltext.click();
			tearDown();
		}
	}

	public static void loadapplication() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		System.out.println(d.getWindowHandle());
		d.navigate().refresh();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		d.quit();
	}

}

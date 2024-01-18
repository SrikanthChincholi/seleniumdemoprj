package selenium_demo.experiencing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author DELL
 *
 */
public class OrangeHRMClass {

	static WebDriver d = null;
	public static String Xpath_username = "//input[@name='username']";
	public static String Xpath_password = "//input[@name='password']";
	public static String CssSelector_submit = "button[type='submit']";

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		waitForElement(2);
		d.manage().window().maximize();
		WebElement username = getElement(By.xpath(Xpath_username));
		if (username.isDisplayed()) {
			username.sendKeys("admin");
		} else {
			throw new Exception("Element not displayed !!");
		}
		WebElement password = getElement(By.xpath(Xpath_password));
		password.sendKeys("admin123");
		System.out.println(password.getAttribute("value"));
		System.out.println(password.getAttribute("class"));
		System.out.println(password.getTagName());
		System.out.println(password.getCssValue("border"));
		WebElement submit = getElement(By.cssSelector(CssSelector_submit));
		System.out.println(submit.getCssValue("color"));
		System.out.println(submit.getText());
		waitForElement(4);
		if (submit.isEnabled()) {
			submit.submit();
		} else {
			throw new Exception("Element not enabled !!");
		}
		waitForElement(5);
		d.close();

	}

	/**
	 * 
	 * @param by
	 * @return
	 */

	public static WebElement getElement(By by) {
		return d.findElement(by);
	}

	/**
	 * 
	 * @param milliseconds
	 * @throws Exception
	 */
	public static void waitForElement(long milliseconds) throws Exception {
		synchronized (d) {
			d.wait(milliseconds * 1000);
		}
	}

}

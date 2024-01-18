package selenium.javascriptExecutor;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSObjectIdentificationwithdiffAttributes {
	static WebDriver d;

	public static void main(String[] args) throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) d);
		WebElement uname = (WebElement) js.executeScript(
				"return document.evaluate(\"//input[@name='username']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE).singleNodeValue");
		uname.sendKeys("admin");
		WebElement pswd = (WebElement) js.executeScript(
				"return document.evaluate(\"//input[@name='password']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE).singleNodeValue");
		pswd.sendKeys("admin123");
		WebElement login = (WebElement) js.executeScript(
				"return document.querySelector(\"button[type='submit']\")");
		login.click();

		Thread.sleep(5000);
		d.quit();
	}

}

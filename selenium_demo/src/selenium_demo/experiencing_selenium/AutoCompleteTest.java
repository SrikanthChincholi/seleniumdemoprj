package selenium_demo.experiencing_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * 
 * @author DELL
 *
 */

public class AutoCompleteTest {

	static WebDriver d;

	public static void main(String[] args) throws Exception {

		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/AutoComplete.html");
		Thread.sleep(3000);
		WebElement inputbox = d.findElement(By.xpath("//input[@id='searchbox']"));
		inputbox.click();
		//inputbox.sendKeys("us");
		Thread.sleep(3000);
		//System.out.println(allcountries.size());
		String str[] = { "Russia", "Cyprus", "Austria" };
		for (int i = 0; i < str.length; i++) {
			inputbox.sendKeys("us");
			Thread.sleep(3000);
			List<WebElement> allcountries = d.findElements(By.xpath("//ul//li//a[@class='ui-corner-all']"));
			for (WebElement country : allcountries) {
				String name = country.getText();
			//	System.out.println(name);
				if (name.equals(str[i])) {
					country.click();
					Thread.sleep(4000);
				}
			}
		}
	}

}

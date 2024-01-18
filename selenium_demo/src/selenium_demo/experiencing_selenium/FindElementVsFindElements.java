package selenium_demo.experiencing_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElements {

	static WebDriver d;

	static String tags[] = { "Sell", "Mobiles", "Prime" };

	public static void main(String[] args) throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		List<WebElement> allatags = d.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		System.out.println(allatags.size());
		for (int j = 0; j < tags.length; j++) {
			for (int i = 0; i < allatags.size(); i++) {
				allatags = d.findElements(By.xpath("//div[@id='nav-xshop']/a"));
				String tagtext = allatags.get(i).getText();
				if (tags[j].equals(tagtext)) {
					allatags.get(i).click();
					Thread.sleep(3000);
					d.navigate().back();
					Thread.sleep(3000);
					break;
				}
			}
		}
		Thread.sleep(3000);
		d.quit();

	}
}

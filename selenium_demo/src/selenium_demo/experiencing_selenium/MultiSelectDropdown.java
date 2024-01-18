package selenium_demo.experiencing_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown {
	static WebDriver d = null;

	public static void main(String[] args) throws Exception {
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://www.letskodeit.com/practice");
		Thread.sleep(3000);
		WebElement mselect = d.findElement(By.xpath("//select[@name='multiple-select-example']"));
		highlightEle(mselect);
		Select multiselect = new Select(mselect);
		if (multiselect.isMultiple()) {
			List<WebElement> alloptions = multiselect.getOptions();
			for (WebElement option : alloptions) {
				System.out.println(option.getText());
			}
			multiselect.selectByIndex(1);
			Thread.sleep(3000);
			multiselect.selectByVisibleText("Apple");
			Thread.sleep(3000);
			multiselect.selectByValue("peach");
			Thread.sleep(3000);
			// System.out.println(multiselect.getFirstSelectedOption().getText());
			multiselect.deselectByVisibleText("Apple");
			System.out.println("***************************");
			List<WebElement> getallselectedopt = multiselect.getAllSelectedOptions();
			for (WebElement option : getallselectedopt) {
				System.out.println(option.getText());
			}
			// multiselect.deselectAll();
			Thread.sleep(3000);
			d.quit();
		}
	}

	public static void highlightEle(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 2px solid red;')", ele);

	}
}

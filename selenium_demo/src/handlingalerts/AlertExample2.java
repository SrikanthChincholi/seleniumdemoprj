package handlingalerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample2 {
	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Alerts.html");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		highlight(ele);
		ele.click();
		Thread.sleep(2000);
		ele = d.findElement(
				By.xpath("//div[@id='CancelTab']/child::button[text()='click the button to display a confirm box ']"));
		highlight(ele);
		ele.click();
		Thread.sleep(3000);
		Alert alt = d.switchTo().alert();
		alt.accept();
		ele = d.findElement(By.xpath("//div[@id='CancelTab']/child::p"));
		System.out.println(ele.getText());
		if (ele.getText().contains("Ok")) {
			System.out.println("Clicked on Ok");
		} else if (ele.getText().contains("Cancel")) {
			System.out.println("Clicked on Cancel");
		} else {
			System.out.println("Text did not match !!");
		}
	}

	public static void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background : yellow; border : 3px solid red;')", ele);
	}
}

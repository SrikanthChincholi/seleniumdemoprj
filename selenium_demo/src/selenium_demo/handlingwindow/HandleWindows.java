package selenium_demo.handlingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindows {
	static WebDriver d;

	public static void main(String[] args) throws Exception {

		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Windows.html");
		Thread.sleep(3000);
		String pwnd = d.getWindowHandle();
		System.out.println(pwnd);
		Thread.sleep(2000);
		d.findElement(By.xpath("(//button[text()[normalize-space() ='click']])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//button[text()[normalize-space() ='click']])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//button[text()[normalize-space() ='click']])[3]")).click();
		Thread.sleep(2000);
		
		Set<String> allwinds = d.getWindowHandles();
		System.out.println(allwinds.size());
		for (String wnd : allwinds) {
			System.out.println(wnd);
		}
		for (String wnd : allwinds) {
			if (!wnd.equals(pwnd)) {
				d.switchTo().window(wnd);
				Thread.sleep(2000);
			//	d.findElement(By.xpath("//a/span[text()='Downloads']")).click();
			//	Thread.sleep(3000);
				System.out.println(d.getTitle());
		//		d.close();
			}
		}
		List<String> allwndlist = new ArrayList();
		allwndlist.addAll(allwinds);
		d.switchTo().window(allwndlist.get(4));
		System.out.println(d.getTitle());
		Thread.sleep(5000);
		d.switchTo().window(pwnd);
		System.out.println(d.getTitle());
		Thread.sleep(5000);
		d.quit();
	}
}

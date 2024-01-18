package broken_links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	static WebDriver d;
	static WebElement ele;

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		List<WebElement> alltags = d.findElements(By.tagName("a"));
		System.out.println(alltags.size());
		for (int i = 0; i < alltags.size(); i++) {
			String url = alltags.get(i).getAttribute("href");
			if (url == null || url == "")
				continue;
			URL urllink = new URL(url);
			HttpURLConnection con = (HttpURLConnection) urllink.openConnection();
			con.connect();
			con.setConnectTimeout(2000);
			if (con.getResponseCode() >= 400) {
				System.err.println(url + " is broken " + con.getResponseCode());
			} else {
				System.out.println(url + " is working " + con.getResponseCode());
			}

		}
		d.quit();

	}
}

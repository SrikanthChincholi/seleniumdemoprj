package selenium_demo.experiencing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exampleofelements {

	static WebDriver d = null;

	public static void main(String[] args) throws Exception {
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		WebElement fname = d.findElement(By.xpath("//input[@placeholder='First Name']"));
		fname.sendKeys("Srikanth");
		System.out.println(fname.getAttribute("value"));
		WebElement textarea = d.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		textarea.sendKeys("This is the text area");
		WebElement radiobtnf = d.findElement(By.xpath("//input[@value='FeMale']"));
		radiobtnf.click();
		Thread.sleep(3000);
		WebElement radiobtnm = d.findElement(By.xpath("//input[@value='Male']"));
		radiobtnm.click();
		Thread.sleep(3000);
		WebElement cricket = d.findElement(By.cssSelector("input[value='Cricket']"));
		cricket.click();
		Thread.sleep(3000);
		WebElement movies = d.findElement(By.cssSelector("input[value='Movies']"));
		movies.click();
		Thread.sleep(3000);
		WebElement hockey = d.findElement(By.cssSelector("input[value='Hockey']"));
		hockey.click();
		
		
		d.quit();

	}

}

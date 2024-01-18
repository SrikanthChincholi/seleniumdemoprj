package seleniumexceptions;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionExamples {
	static WebDriver d = null;
	static WebElement ele;
	static String str[] = { "Srikanth", "Chincholi", "Chandu", "Aaryan" };

	public static void main(String[] args) throws Exception {
		// staleRefException();
		// elementNotInteractableException();
		// noSuchElementException();
		// InvalidExpressionException();
		// elementClickInterceptedException();
		// noSuchframeException();
		// noAlertException();
		// nosuchWindowException();
		nullpointerException();
	}

	public static void staleRefException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//input[@placeholder='First Name']"));
		for (String s : str) {
			ele.sendKeys(s);
			Thread.sleep(3000);
			d.navigate().refresh();
			// ele = d.findElement(By.xpath("//input[@placeholder='First Name']"));
			ele.clear();
		}
	}

	public static void elementNotInteractableException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//label[text()='Full Name* ']"));
		ele.sendKeys("Srikanth");
	}

	public static void noSuchElementException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//label[text()='Full Name']"));
		ele.sendKeys("Srikanth");

	}

	public static void InvalidSelectorException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//label[text()='Full Name*]"));
		ele.sendKeys("Srikanth");
	}

	public static void elementClickInterceptedException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		ele = d.findElement(By.xpath("//button[@id='submitbtn']"));
		ele.click();
	}

	public static void noSuchframeException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(2000);
		d.switchTo().frame("(//iframe[@src='singleframe'])[5]");
		ele = d.findElement(By.xpath("//input[@type='text']"));
		ele.sendKeys("testdata");
	}

	public static void noAlertException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(2000);
		Alert alt = d.switchTo().alert();
		alt.accept();
		ele = d.findElement(By.xpath("//input[@type='text']"));
		ele.sendKeys("testdata");
	}

	public static void nosuchWindowException() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Windows.html");
		Thread.sleep(2000);
		String pwnd = d.getWindowHandle();
		d.findElement(By.xpath("//a//button[contains(text(),'click')]")).click();
		Set<String> allwnds = d.getWindowHandles();
		for (String wnd : allwnds) {
			if (!pwnd.equals(wnd)) {
				d.switchTo().window(wnd);
				d.close();
				d.findElement(By.xpath("//span[text()='Downloads']")).click();
			}
		}
	}
	

	public static void nullpointerException() throws Exception {
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Windows.html");
		Thread.sleep(2000);
		String pwnd = d.getWindowHandle();
		d.findElement(By.xpath("//a//button[contains(text(),'click')]")).click();
		Set<String> allwnds = d.getWindowHandles();
		for (String wnd : allwnds) {
			if (!pwnd.equals(wnd)) {
				d.switchTo().window(wnd);
				d.close();
				d.findElement(By.xpath("//span[text()='Downloads']")).click();
			}
		}
	}

}

package fileupload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	static WebDriver d;
	static String strtxt = "";
	static String filepath = "C:\\Users\\DELL\\Downloads\\importData.csv";

	public static void main(String[] args) throws Exception {

		d = new ChromeDriver();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.manage().window().maximize();
		WebElement uname = d.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys("admin");
		WebElement pswd = d.findElement(By.xpath("//input[@name='password']"));
		pswd.sendKeys("admin123");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement dashboard = waitforElement(By.xpath("//span/h6[text()='Dashboard']"));
		if (dashboard.isDisplayed()) {
			d.findElement(By.xpath("//span[text()='PIM']")).click();
			WebElement navigationbar = waitforElement(By.xpath("(//nav[@role='navigation'])[2]"));
			if (navigationbar.isDisplayed()) {
				WebElement config = d.findElement(By.xpath("//span[text()='Configuration ']/parent::li"));
				config.click();
				List<WebElement> alloptions = d.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li/a"));
				for (WebElement option : alloptions) {
					if (option.getText().equals("Data Import")) {
						option.click();
						WebElement dataimp = waitforElement(By.xpath("//p[text()='Data Import']"));
						if (dataimp.isDisplayed())
							break;
					}
				}

				WebElement browse = d.findElement(By.xpath("//div[text()='Browse']"));
				browse.click();

				copytxtpasteIt(filepath);

				d.findElement(By.xpath("//button[@type='submit']")).click();
				WebElement msgheader = waitforElement(By.xpath("//div[@class='orangehrm-modal-header']"));
				if (msgheader.isDisplayed()) {
					List<WebElement> msgtext = d
							.findElements(By.xpath("//div[@class='orangehrm-text-center-align']/p"));
					for (WebElement msg : msgtext) {
						strtxt = strtxt + msg.getText() + "\n";
					}
					if (strtxt.contains("Failed") || strtxt.contains("No Records"))
						System.out.println("------File upload Failed------ " + "\n" + strtxt);
					else if (strtxt.contains("Success"))
						System.out.println("------File upload Success-----" + "\n" + strtxt);
					else
						System.out.println("------File Upload status------ " + "\n" + strtxt);
					Thread.sleep(2000);
					d.findElement(By.xpath("//button[contains(@class,'oxd-dialog-close-button')]")).click();
					Thread.sleep(4000);
					d.quit();
				}
			}
		}
	}

	public static WebElement waitforElement(By by) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void copytxtpasteIt(String txt) throws Exception {

		StringSelection str = new StringSelection(txt);
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(str, null);

		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
	}

}

package takescreens;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataproviderpack.DataProviderContainer;

public class TestScreenshot {

	static WebDriver d;

	@Test(dataProvider = "logintestdata", dataProviderClass = DataProviderContainer.class)
	public void loginTestwithData(String username, String password) throws Exception {
		logintest(username, password);
	}

	private void logintest(String username, String password) throws Exception {
		try {
			d = new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			d.findElement(By.xpath("//input[@name='password']")).sendKeys(password, Keys.RETURN);
			List<WebElement> dashboard = d.findElements(By.xpath("//h6[text()='Dashboard']"));
			Assert.assertEquals(dashboard.get(0).getText(), "Dashboard", "Login Success !!");

		} catch (Exception e) {
			e.printStackTrace();
			DateFormat date_format = new SimpleDateFormat("mm_dd_yy_HH_mm_ss");
			Calendar date_obj = Calendar.getInstance();
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			File Destloc = new File(System.getProperty("user.dir") + "//ScreenShots//" + date_format.format(date_obj.getTime()) + "_FailedTest.png");
			FileUtils.copyFile(screenshotFile, Destloc);
		} finally

		{
			d.quit();
		}
	}

}

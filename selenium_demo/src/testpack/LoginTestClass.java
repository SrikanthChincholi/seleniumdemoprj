package testpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import basepacck.BaseTest;
import dataproviderpack.DataProviderContainer;

public class LoginTestClass extends BaseTest {

	@Test(dataProvider = "readdata", dataProviderClass = DataProviderContainer.class)
	public void login(String username, String password) {
		d.get().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		d.get().findElement(By.xpath("//input[@name='password']")).sendKeys(password, Keys.RETURN);
		List<WebElement> dashboard = d.get().findElements(By.xpath("//h6[text()='Dashboard']"));
		Assert.assertEquals(dashboard.get(0).getText(), "Dashboard", "Login Success !!");
		throw new SkipException("Test Failed");
	}

}

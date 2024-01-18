package selenium_grid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class RemoteClass {

	DesiredCapabilities cap = new DesiredCapabilities();
	ThreadLocal<RemoteWebDriver> d = new ThreadLocal<>();

	@Parameters({ "browser" })
	@BeforeMethod
	public void setBrowser(String browser) throws Exception {
		if (browser.equals("chrome")) {
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
			d.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
		} else if (browser.equals("firefox")) {

			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			d.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
		} else if (browser.equals("edge")) {

			cap.setBrowserName("edge");
			cap.setPlatform(Platform.ANY);
			d.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
		}

	}

	@AfterMethod
	public void tearDown() {

		d.get().quit();
	}

	@AfterClass
	public void removeThread() {
		d.remove();
	}

}

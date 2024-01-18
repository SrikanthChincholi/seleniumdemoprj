package selenium_grid;

import org.testng.annotations.Test;

public class FirefoxGrid extends RemoteClass {

	@Test
	public void getTitle1() throws Exception {
		d.get().manage().window().maximize();
		d.get().get("https://www.google.com");
		System.out.println(d.get().getTitle());
		Thread.sleep(10000);
		// d.get().quit();
	}

}

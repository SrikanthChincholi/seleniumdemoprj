package paralleltest;

import org.testng.annotations.Test;

import basepacck.BaseTest;

public class ParallelExecution3 extends BaseTest {

	@Test()
	public void launchapplication() throws Exception {

		System.out.println(d.get().getWindowHandle());
		Thread.sleep(3000);

	}

}

package paralleltest;

import org.testng.annotations.Test;

import basepacck.BaseTest;

public class ParallelExecution2 extends BaseTest {

	@Test()
	public void launchapplication() throws Exception {

		System.out.println(d.get().getCurrentUrl());
		Thread.sleep(3000);

	}


}

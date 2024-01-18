package paralleltest;

import org.testng.annotations.Test;

import basepacck.BaseTest;

public class ParallelExecution1 extends BaseTest {

	@Test(description = "ParallelExecution1")
	public void launchapplication() throws Exception {

		System.out.println(d.get().getTitle());
		Thread.sleep(3000);

	}

	

}

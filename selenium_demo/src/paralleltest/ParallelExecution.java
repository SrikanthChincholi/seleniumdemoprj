package paralleltest;

import org.testng.annotations.Test;

import basepacck.BaseTest;

public class ParallelExecution extends BaseTest {

	@Test()
	public void launchapplication() throws Exception {

		System.out.println(d.get().getTitle());
		Thread.sleep(3000);

	}

	@Test()
	public void launchapplication1() throws Exception {

		System.out.println(d.get().getTitle());
		Thread.sleep(3000);

	}

	@Test()
	public void launchapplication2() throws Exception {

		System.out.println(d.get().getTitle());
		Thread.sleep(3000);

	}

}

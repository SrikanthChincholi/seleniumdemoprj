package testpack;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public void test1() throws Exception {
		System.out.println("This is test1");
		throw new Exception("just to test method dependencies");
	}

	@Test(dependsOnMethods = "test1", alwaysRun = true)
	public void test2() {
		System.out.println("This is test2");
	}

	//@Test(dependsOnMethods = "test2")
	public void test3() {
		System.out.println("This is test3");
	}
	
	@Test(dependsOnMethods = "test3",ignoreMissingDependencies = true)
	public void test4() {
		System.out.println("This is test3");
	}

}

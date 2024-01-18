package testpack;

import org.testng.annotations.Test;

public class DependsOnGroups {

	@Test(groups = { "test1" })
	public void test1() throws Exception {
		System.out.println("This is test1");
		throw new Exception("just to test method dependencies");
	}

	@Test(groups = { "test2" }, dependsOnGroups = "test1", alwaysRun = true)
	public void test2() {
		System.out.println("This is test2");
	}

	@Test(groups = { "test3" })
	public void test3() {
		System.out.println("This is test3");
	}

	@Test(groups = { "test4" })
	public void test4() {
		System.out.println("This is test3");
	}

}

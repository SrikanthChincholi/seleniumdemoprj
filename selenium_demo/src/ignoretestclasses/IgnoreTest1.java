package ignoretestclasses;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
@Ignore
public class IgnoreTest1 {

	
	@Test
	public void test1() {
		System.out.println("This is a test1");
	}

	@Test
	public void test2() {
		System.out.println("This is a test2");
	}

	@Test
	public void test3() {
		System.out.println("This is a test3");
	}

	@Test
	public void test4() {
		System.out.println("This is a test4");
	}

	@Test
	public void test5() {
		System.out.println("This is a test5");
	}

	@Test
	public void test6() {
		System.out.println("This is a test6");
	}
}

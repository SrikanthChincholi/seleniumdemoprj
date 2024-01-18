package testngprgms;

import org.testng.annotations.Test;

public class SimpleTestNG {
	
	@Test(invocationCount =  5)
	public void test1()
	{
		System.out.println("This is sample test1");
	}
	@Test(enabled = true)
	public void test2()
	{
		System.out.println("This is sample test2");
	}
}

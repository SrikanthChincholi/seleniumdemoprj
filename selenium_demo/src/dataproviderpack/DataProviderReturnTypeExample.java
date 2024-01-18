package dataproviderpack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturnTypeExample {
	// @Test(dataProvider = "dp1")
	public void test1(String s) {
		System.out.println(s);
	}

	// @Test(dataProvider = "dp2")
	public void test2(String s1, String s2) {
		System.out.println(s1 + " >>>>>> " + s2);
	}

	// @Test(dataProvider = "dp3")
	public void test3(String s) {
		System.out.println(s);
	}

	@Test(dataProvider = "dp4")
	public void test4(String s[]) {
		for (String str : s)
			System.out.println(str);
	}

	@DataProvider(name = "dp1")
	public Object[] data1() {
		return new Object[] { "admin", "admin123" };
	}

	@DataProvider(name = "dp2")
	public Object[][] data2() {
		return new Object[][] { { "admin", "admin123" }, { "admin1", "admin123" } };
	}

	@DataProvider(name = "dp3")
	public Iterator<String> data3() {
		List<String> list = new ArrayList<>();
		list.add("admin");
		list.add("admin123");
		list.add("admin1");
		list.add("admin123");
		return list.iterator();

	}

	@DataProvider(name = "dp4")
	public Iterator<String[]> data4() {
		List<String[]> list = new ArrayList<>();
		list.add(new String[] { "admin", "admin123" });
		list.add(new String[] { "admin1", "admin123" });
		return list.iterator();
	}

}

package retryanalyzers;

import org.testng.annotations.Test;

public class TestClass2 {
	int i = 0;

	@Test
	public void test1() throws Exception {
		while (true) {
			i++;
			if (i == 3) {
				System.out.println("value of i is :" + i);
				break;
			} else {
				throw new Exception(" i value is not 10");
			}
		}
	}
	
	@Test
	public void test2() throws Exception {
		i = 0;
		while (true) {
			i++;
			if (i == 6) {
				System.out.println("value of i is :" + i);
				break;
			} else {
				throw new Exception(" i value is not 10");
			}
		}
	}

}

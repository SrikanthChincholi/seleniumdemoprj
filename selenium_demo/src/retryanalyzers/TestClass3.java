package retryanalyzers;

import org.testng.annotations.Test;

public class TestClass3 {
	int i = 0;

	@Test
	public void test1() throws Exception {
		while (true) {
			i++;
			if (i == 7) {
				System.out.println("value of i is :" + i);
				break;
			} else {
				throw new Exception(" i value is not 10");
			}
		}
	}

}

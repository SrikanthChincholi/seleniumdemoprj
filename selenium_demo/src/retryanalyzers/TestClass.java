package retryanalyzers;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass {
	int i = 0;

	@Test
	public void test1(Method method) throws Exception {
		while (true) {
			i++;
			if (i == 4) {
				System.out.println("value of i is :" + i);
				break;
			} else {
				Reporter.log("Failed attempt" + method.getName(), 2);
				throw new Exception(" i value is not 10");
			}
		}
	}
	
	@Test
	public void test2(Method method) throws Exception {
		i = 0;
		while (true) {
			i++;
			if (i == 5) {
				System.out.println("value of i is :" + i);
				break;
			} else {
				Reporter.log("Failed attempt" + method.getName());
				throw new Exception(" i value is not 10");
			}
		}
	}

}

package retryanalyzers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {

	int count = 0;
	int maxattempt = 7;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (count < maxattempt) {
				count++;
				return true;
			}
		}
		return false;
	}

}

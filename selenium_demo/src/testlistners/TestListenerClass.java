package testlistners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "Test Started !!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + "Test Success !!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + "Test Failed !!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + "Test Skipped !!" + result.getStatus());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + " Started !!");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + " Finished !!");
	}

}

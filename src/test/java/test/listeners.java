package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.Base;

public class listeners implements ITestListener {

	Base B = new Base();
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		log.info("***** Error " + arg0.getName() + " test has failed *****");
		String testMethodName = arg0.getMethod().getMethodName();
		try {
			B.screenCapture(testMethodName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

		log.info("***** Success " + arg0.getName() + " test has passed *****");
		String testMethodName = arg0.getMethod().getMethodName();
		try {
			B.screenCapture(testMethodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

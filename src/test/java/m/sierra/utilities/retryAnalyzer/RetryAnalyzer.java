package m.sierra.utilities.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private int retryLimit = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < retryLimit) {
            retryCount++;
            return true;
        }
        return false;
    }
}

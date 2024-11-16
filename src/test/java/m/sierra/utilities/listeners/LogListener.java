package m.sierra.utilities.listeners;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import m.sierra.Utilities.LogParserUtility;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class LogListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Thread.currentThread().setName("thread" + Thread.currentThread().getId());
        String qualifiedName = String.format("%s.%s", iTestResult.getTestClass().getName(), iTestResult.getName());
        long nanoTime = System.nanoTime();
        iTestResult.getTestContext().setAttribute(qualifiedName, nanoTime);
        log.info("{} {}({})", "TEST", qualifiedName, nanoTime);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("TEST PASS: {} {}", iTestResult.getName(), iTestResult.getParameters());
        getTestLog(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("TEST FAIL: {} {}\n{}", iTestResult.getName(), iTestResult.getParameters(), iTestResult.getThrowable().getMessage());
        getTestLog(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.warn("TEST SKIP: {} {}", iTestResult.getName(), iTestResult.getParameters());
        getTestLog(iTestResult);
    }

    @Attachment(value = "log", type = "text/plain")
    private String getTestLog(ITestResult testName) {
        String qualifiedName = testName.getMethod().getQualifiedName();
        String nanoTime = String.valueOf(testName.getTestContext().getAttribute(qualifiedName));
        return LogParserUtility.getParsedTestLog(String.format("%s(%s)", qualifiedName, nanoTime));
    }

}

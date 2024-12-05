package m.sierra.utilities.listeners;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import m.sierra.Utilities.LogParserUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

@Log4j2
public class LogListener implements ITestListener {

    private static final String LOG_FILE_PATH = "target/logs/log.log";
    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;
    private int broken = 0;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Thread.currentThread().setName("thread" + Thread.currentThread().getId());
        String qualifiedName = String.format("%s.%s", iTestResult.getTestClass().getName(), iTestResult.getName());
        long nanoTime = System.nanoTime();
        iTestResult.getTestContext().setAttribute(qualifiedName, nanoTime);
        log.info("{} {}({})", "TEST", qualifiedName, nanoTime);
        ensureLogFileExists();
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

    private void ensureLogFileExists() {
        File logFile = new File(LOG_FILE_PATH);
        if (!logFile.exists()) {
            try {
                logFile.getParentFile().mkdirs();
                logFile.createNewFile();
            } catch (IOException e) {
                log.error("Failed to create log file: {}", LOG_FILE_PATH, e);
            }
        }
    }

    @Override
    public void onStart(ITestContext context) {
        // Reset counters at the start of the test context
        passed = 0;
        failed = 0;
        skipped = 0;
        broken = 0;
    }

    @Override
    public void onFinish(ITestContext context) {
        // Store results in the context for later retrieval
        context.setAttribute("passed", passed);
        context.setAttribute("failed", failed);
        context.setAttribute("skipped", skipped);
        context.setAttribute("broken", broken);
    }

}

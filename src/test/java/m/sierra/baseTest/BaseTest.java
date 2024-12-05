package m.sierra.baseTest;

import m.sierra.Driver.PlaywrightFactory;
import m.sierra.Pages.BasePage;
import m.sierra.SlackReportSender.SlackReportUtil;
import m.sierra.Utilities.BrowserUtils;
import m.sierra.utilities.listeners.LogListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(LogListener.class)
public class BaseTest extends PlaywrightFactory {

    SlackReportUtil slackReportUtil = new SlackReportUtil();
    LogListener logListener = new LogListener();

    @BeforeClass
    @Parameters({"appURL", "browserType"})
    public void setUp(@Optional("https://playwright.dev/") String appURL,
                      @Optional("chrome") String browserType, ITestContext context) {
        logListener.onStart(context);
        slackReportUtil.setupParentMessage();
        page = getPage(appURL, browserType);
        BasePage.setAndConfigurePage(page);
        BrowserUtils browserUtils = new BrowserUtils(page.context().browser());
        browserUtils.newPageContext()
                .startVideoRecording();
        slackReportUtil.setupParentMessage();
    }

    @AfterClass
    public void tearDown(ITestContext context) {
//        takeScreenshot();
        if (page != null) {
            page.context().browser().close();
        }
        if (playwright != null) {
            playwright.close();
        }
        logListener.onFinish(context);
        slackReportUtil.sendTestResults(context);
    }

}

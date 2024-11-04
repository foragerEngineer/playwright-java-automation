package m.sierra.Tests;

import com.microsoft.playwright.Page;
import m.sierra.Driver.PlaywrightFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected Page page;
    PlaywrightFactory driver;

    @BeforeClass
    @Parameters({"appURL", "browserType"})
    public void setUp(@Optional("https://playwright.dev/") String appURL,
                      @Optional("chrome") String browserType) {
        driver = new PlaywrightFactory();
        page = driver.getPage(appURL, browserType);
    }

    @AfterClass
    public void tearDown() {
        if (page != null) {
            page.context().browser().close();
        }
//        FileUtility forwarder = new FileUtility();
//        forwarder.forwardAllureResults();
    }

}

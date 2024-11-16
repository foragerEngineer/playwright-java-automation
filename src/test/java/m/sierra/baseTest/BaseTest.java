package m.sierra.baseTest;

import m.sierra.Driver.PlaywrightFactory;
import m.sierra.Pages.BasePage;
import m.sierra.Utilities.BrowserUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends PlaywrightFactory{

    @BeforeClass
    @Parameters({"appURL", "browserType"})
    public void setUp(@Optional("https://playwright.dev/") String appURL,
                      @Optional("chrome") String browserType) {
        page = getPage(appURL, browserType);
        BasePage.setAndConfigurePage(page);
        BrowserUtils browserUtils = new BrowserUtils(page.context().browser());
        browserUtils.newPageContext()
                .startVideoRecording();
    }

    @AfterClass
    public void tearDown() {
        if (page != null) {
            page.context().browser().close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

}

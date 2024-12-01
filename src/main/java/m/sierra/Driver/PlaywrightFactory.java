package m.sierra.Driver;

import com.microsoft.playwright.*;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;

public class PlaywrightFactory {

    public Playwright playwright;
    protected Page page;
    Browser browser;
    BrowserContext browserContext;

    @Parameters({"appURL", "browserType"})
    public Page getPage(String appURL, String browserType) {
        playwright = Playwright.create();
        switch (browserType) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(appURL);
        return page;
    }

    @Step
    public void takeScreenshot() {
        page.screenshot();
    }

}
